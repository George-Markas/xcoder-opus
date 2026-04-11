SRC_DIR := src/main/c/src
INC_DIR := src/main/c/include
OBJ_DIR := target/c

TARGET := src/main/resources/native/linux-x86-64/libxcoder-opus.so

JAVA_HOME ?= $(shell dirname $$(dirname $$(readlink -f $$(which javac))))

SRC := $(wildcard $(SRC_DIR)/*.c)
INC := $(addprefix -I, $(INC_DIR) $(JAVA_HOME)/include $(JAVA_HOME)/include/linux)
OBJ := $(patsubst $(SRC_DIR)/%.c, $(OBJ_DIR)/%.o, $(SRC))

CC      := gcc
CFLAGS  := -std=c11 -Wall -Wextra -Werror -pedantic -O2 -fPIC
LDFLAGS := -shared
LDLIBS  := -lavformat -lavcodec -lavutil -lswresample

all: $(TARGET)

.PHONY: all clean

$(OBJ_DIR):
	mkdir -p $@

$(OBJ_DIR)/%.o: $(SRC_DIR)/%.c | $(OBJ_DIR)
	$(CC) $(CFLAGS) -c $^ $(INC) -o $@

$(TARGET): $(OBJ)
	$(CC) $^ $(LDFLAGS) $(LDLIBS) -o $@

clean:
	rm -rf $(OBJ_DIR) $(TARGET)