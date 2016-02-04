package com.github.badoualy.telegram.tl.api.request;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsChannelParticipantRole;
import com.github.badoualy.telegram.tl.api.TLAbsInputChannel;
import com.github.badoualy.telegram.tl.api.TLAbsInputUser;
import com.github.badoualy.telegram.tl.api.TLAbsUpdates;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestChannelsEditAdmin extends TLMethod<TLAbsUpdates> {
    public static final int CONSTRUCTOR_ID = 0xeb7611d0;

    protected TLAbsInputChannel channel;

    protected TLAbsInputUser userId;

    protected TLAbsChannelParticipantRole role;

    public TLRequestChannelsEditAdmin() {
    }

    public TLRequestChannelsEditAdmin(TLAbsInputChannel channel, TLAbsInputUser userId, TLAbsChannelParticipantRole role) {
        this.channel = channel;
        this.userId = userId;
        this.role = role;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TLAbsUpdates deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsUpdates)) {
            throw new IOException("Incorrect response type, expected getClass().getCanonicalName(), found response.getClass().getCanonicalName()");
        }
        return (TLAbsUpdates) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(channel, stream);
        writeTLObject(userId, stream);
        writeTLObject(role, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        channel = (com.github.badoualy.telegram.tl.api.TLAbsInputChannel) readTLObject(stream, context);
        userId = (com.github.badoualy.telegram.tl.api.TLAbsInputUser) readTLObject(stream, context);
        role = (com.github.badoualy.telegram.tl.api.TLAbsChannelParticipantRole) readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "channels.editAdmin#eb7611d0";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public TLAbsInputChannel getChannel() {
        return channel;
    }

    public void setChannel(TLAbsInputChannel channel) {
        this.channel = channel;
    }

    public TLAbsInputUser getUserId() {
        return userId;
    }

    public void setUserId(TLAbsInputUser userId) {
        this.userId = userId;
    }

    public TLAbsChannelParticipantRole getRole() {
        return role;
    }

    public void setRole(TLAbsChannelParticipantRole role) {
        this.role = role;
    }
}