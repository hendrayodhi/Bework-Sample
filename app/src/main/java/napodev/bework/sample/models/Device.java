package napodev.bework.sample.models;

import android.os.Parcel;

import napodev.framework.bework.corebase.model.parcel.BaseParcelable;
import napodev.framework.bework.corebase.model.parcel.Entity;
import napodev.framework.bework.corebase.model.parcel.ParcelInject;

/**
 * Created by opannapo on 4/29/17.
 */
public class Device extends BaseParcelable {
    @Entity(ParcelInject.INT)
    public int id;
    @Entity(ParcelInject.STRING)
    public String name;

    public Device() {
    }

    protected Device(Parcel in) {
        super(in);
    }

    public static final Creator<Device> CREATOR = new Creator<Device>() {
        @Override
        public Device createFromParcel(Parcel source) {
            return new Device(source);
        }

        @Override
        public Device[] newArray(int size) {
            return new Device[size];
        }
    };
}
