package org.example.xcoder;

public class XcoderOpus {

    /* 1. SET THIS MANUALLY */
    // <absolute path to project>/src/main/resources/native/linux-x86-64/libxcoder-opus.so
    private static final String SHARED_LIB = "";

    static {
        System.load(SHARED_LIB);
    }

    public native void transcode(String inputFile, String outputFile, int outputBitRate);

    public static void main(String[] args) {
        final int OUTPUT_BIT_RATE = 256000;

        /* 2. SET THESE MANUALLY */
        final String inputFile = "";
        final String outputFile = "";

        new XcoderOpus().transcode(inputFile, outputFile, OUTPUT_BIT_RATE);
    }
}
