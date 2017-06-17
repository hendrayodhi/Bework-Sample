package napodev.bework.sample.models;

import android.annotation.SuppressLint;
import android.os.Parcel;

import org.json.JSONObject;

import napodev.framework.bework.corebase.model.parcel.BaseParcelable;
import napodev.framework.bework.corebase.model.parcel.Entity;
import napodev.framework.bework.corebase.model.parcel.ParcelInject;

/**
 * Created by opannapo on 4/23/17.
 */
@SuppressLint("ParcelCreator")
public class Member extends BaseParcelable {
    @Entity(ParcelInject.STRING)
    public String id;
    @Entity(ParcelInject.STRING)
    public String age;
    @Entity(ParcelInject.STRING)
    public String name;
    @Entity(ParcelInject.STRING)
    public String bio;
    @Entity(ParcelInject.STRING)
    public String myAdv;
    @Entity(ParcelInject.STRING)
    public String city;
    @Entity(ParcelInject.STRING)
    public String country;
    @Entity(ParcelInject.STRING)
    public String imageProfile;
    @Entity(ParcelInject.STRING)
    public String imageCover;
    @Entity(ParcelInject.JSONOBJECT)
    public JSONObject data;
    @Entity(ParcelInject.STRING_ARRAY)
    public String[] addrName;
    @Entity(ParcelInject.INT_ARRAY)
    public int[] addrNo;
    @Entity(ParcelInject.DOUBLE_ARRAY)
    public double[] addrLat;
    @Entity(ParcelInject.LONG_ARRAY)
    public long[] addrLon;
    @Entity(ParcelInject.PARCELABLE)
    public Device device;
    @Entity(ParcelInject.BOOLEAN)
    public boolean isActive;

    public Member() {
    }

    public Member(Parcel in) {
        super(in);
    }

    public static final Creator<Member> CREATOR = new Creator<Member>() {
        @Override
        public Member createFromParcel(Parcel in) {
            return new Member(in);
        }

        @Override
        public Member[] newArray(int size) {
            return new Member[size];
        }
    };

}
