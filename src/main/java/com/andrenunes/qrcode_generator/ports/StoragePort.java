package com.andrenunes.qrcode_generator.ports;

public interface StoragePort {
    String upLoadFile(byte[] file, String fileName, String contentType);
}
