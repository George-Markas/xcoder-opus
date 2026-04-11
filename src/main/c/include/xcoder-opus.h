#pragma once

#include <stdint.h>
#include <jni.h>

/**
 * Transcode an audio file to OGG Opus.
 * @param j_input_file  The audio file to transcode.
 * @param j_output_file The name of the output file. This does not include
 * the file extension, that will always be '.ogg' since we're using the
 * OGG container.
 * @param j_output_bit_rate The output bit rate.
 */
JNIEXPORT jint JNICALL
Java_org_example_xcoder_XcoderOpus_transcode(JNIEnv *env,
        __attribute__((unused)) jobject obj, jstring j_input_file,
        jstring j_output_file, jint j_output_bit_rate);
