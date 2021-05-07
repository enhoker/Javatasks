package com.company;

import java.io.OutputStream;

interface Report {
    byte[] asBytes();

    void writeTo(OutputStream os);
}