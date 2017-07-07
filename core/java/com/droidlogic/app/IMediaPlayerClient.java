/*
 * Copyright (C) 2009 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.droidlogic.app;

//** @hide */
public interface IMediaPlayerClient extends android.os.IInterface {
    /** Local-side IPC implementation stub class. */
    public static abstract class Stub extends android.os.Binder implements com.droidlogic.app.IMediaPlayerClient {
        private static final java.lang.String DESCRIPTOR = "android.media.IMediaPlayerClient";

        /** Construct the stub at attach it to the interface. */
        public Stub() {
            this.attachInterface(this, DESCRIPTOR);
        }

        /**
         * Cast an IBinder object into an android.media.IMediaPlayerClientDroidlogic interface,
         * generating a proxy if needed.
         */
        public static com.droidlogic.app.IMediaPlayerClient asInterface(android.os.IBinder obj) {
            if ((obj == null)) {
                return null;
            }

            android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (((iin != null) && (iin instanceof com.droidlogic.app.IMediaPlayerClient))) {
                return ((com.droidlogic.app.IMediaPlayerClient)iin);
            }

            return new com.droidlogic.app.IMediaPlayerClient.Stub.Proxy(obj);
        }

        @Override
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override
        public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException {
            switch (code) {
                case INTERFACE_TRANSACTION:
                {
                    reply.writeString(DESCRIPTOR);
                    return true;
                }

                case TRANSACTION_notify :
                {
                    data.enforceInterface(DESCRIPTOR);
                    int msg = data.readInt();
                    int ext1 = data.readInt();
                    int ext2 = data.readInt();
                    android.os.Parcel obj = android.os.Parcel.obtain();
                    if (data.dataAvail() > 0) {
                        obj.appendFrom(data, data.dataPosition(), data.dataAvail());
                    }
                    this.notify(msg, ext1, ext2, obj);
                    return true;
                }
            }

            return super.onTransact(code, data, reply, flags);
        }

        private static class Proxy implements com.droidlogic.app.IMediaPlayerClient {
            private android.os.IBinder mRemote;
            Proxy(android.os.IBinder remote) {
                mRemote = remote;
            }

            @Override
            public android.os.IBinder asBinder() {
                return mRemote;
            }

            public java.lang.String getInterfaceDescriptor() {
                return DESCRIPTOR;
            }

            @Override
            public void notify(int msg, int ext1, int ext2, android.os.Parcel obj) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();

                try {
                    _data.writeInterfaceToken (DESCRIPTOR);
                    _data.writeInt (msg);
                    _data.writeInt (ext1);
                    _data.writeInt (ext2);
                    if (obj != null && obj.dataSize() > 0) {
                        _data.appendFrom(obj, 0, obj.dataSize());
                    }
                    mRemote.transact (Stub.TRANSACTION_notify, _data, _reply, 0);
                    _reply.readException();
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        static final int TRANSACTION_notify = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    }
    public void notify(int msg, int ext1, int ext2, android.os.Parcel obj) throws android.os.RemoteException;
}
