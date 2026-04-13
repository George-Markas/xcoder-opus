#include "xcoder-opus_internal.h"

int init_packet(AVPacket **packet, JNIEnv *env) {
    if (!(*packet = av_packet_alloc())) {
        print_and_throw(env, "Failed to allocate packet");
        return AVERROR(ENOMEM);
    }

    return 0;
}