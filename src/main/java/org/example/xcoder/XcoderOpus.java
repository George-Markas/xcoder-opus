package org.example.xcoder;

import java.io.IOException;

public class XcoderOpus {

    private static final String LIB_NAME = "xcoder-opus";

    static {
        try {
            NativeLoader.loadLibrary(LIB_NAME);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load native library", e);
        }
    }

    /**
     * Transcode an audio file to Opus.
     * @param inputFile The name of the input file.
     * @param outputFile The name of the output file. The file extension must be that
     * of a compatible container e.g. OGG.
     * @param outputBitRate The output bit rate in Hz e.g. 128000.
     */
    public native void transcodeToOpus(String inputFile, String outputFile, int outputBitRate);
}
