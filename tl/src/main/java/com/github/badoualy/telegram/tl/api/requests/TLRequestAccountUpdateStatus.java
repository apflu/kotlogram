
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;


public class TLRequestAccountUpdateStatus extends TLMethod<TLBool> {

    public static final int CLASS_ID = 0x6628562c;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestAccountUpdateStatus(        boolean _offline) {
        this.offline = _offline;

    }



    public TLBool deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof TLBool) {
            return (TLBool)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected TLBool, got: " + res.getClass().getCanonicalName());
        }

    }
        


    protected boolean offline;


    public boolean getOffline() {
        return offline;
    }

    public void setOffline(boolean value) {
        this.offline = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLBool(this.offline, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.offline = readTLBool(stream);
    }



    @Override
    public String toString() {
        return "account.updateStatus#6628562c";
    }

}