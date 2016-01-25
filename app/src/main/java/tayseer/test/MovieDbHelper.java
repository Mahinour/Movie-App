package tayseer.test;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//import com.example.pc.test.MovieContract.MovieEntry;
import tayseer.test.MovieContract.MovieEntry;

public class MovieDbHelper extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 2;

    static final String DATABASE_NAME = "Movie.db";

    public MovieDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String SQL_CREATE_MOVIE_TABLE = "CREATE TABLE " + MovieEntry.TABLE_NAME + " (" +
                MovieEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +

                // MovieEntry.adult + " TEXT NOT NULL, " +
                MovieEntry.vote_average + " TEXT NOT NULL, " +
                MovieEntry.mid + " INTEGER NOT NULL, " +
                MovieEntry.overview + " TEXT NOT NULL," +
                MovieEntry.poster_path + " TEXT NOT NULL, " +
                MovieEntry.release_date + " TEXT NOT NULL, " +
                MovieEntry.title + " TEXT NOT NULL, " +

                " UNIQUE (" + MovieEntry.mid +") ON CONFLICT REPLACE);";
        sqLiteDatabase.execSQL(SQL_CREATE_MOVIE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + MovieEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
