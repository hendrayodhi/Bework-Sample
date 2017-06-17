package napodev.bework.sample.models;

import android.annotation.SuppressLint;
import android.os.Parcel;

import napodev.framework.bework.corebase.model.parcel.BaseParcelable;
import napodev.framework.bework.corebase.model.parcel.Entity;
import napodev.framework.bework.corebase.model.parcel.ParcelInject;

/**
 * Created by opannapo on 4/23/17.
 */
@SuppressLint("ParcelCreator")
public class Trending extends BaseParcelable {
    @Entity(ParcelInject.INT)
    public int id;
    @Entity(ParcelInject.INT)
    public int type;
    @Entity(ParcelInject.INT)
    public int count;
    @Entity(ParcelInject.STRING)
    public String name;


    public Trending() {
    }

    public Trending(Parcel in) {
        super(in);
    }

    public static final Creator<Trending> CREATOR = new Creator<Trending>() {
        @Override
        public Trending createFromParcel(Parcel in) {
            return new Trending(in);
        }

        @Override
        public Trending[] newArray(int size) {
            return new Trending[size];
        }
    };

}
