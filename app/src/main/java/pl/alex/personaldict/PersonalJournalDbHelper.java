package pl.alex.personaldict;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class PersonalJournalDbHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "personal_dict"; // Имя базы данных
    private static final int DB_VERSION = 1; // Версия базы данных

    public PersonalJournalDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Image (" +
                "  _id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                "  src varchar(50));");

        db.execSQL("CREATE TABLE Note (" +
                "  _id  INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                "  text varchar(50));");
        db.execSQL("CREATE TABLE Post (" +
                "  _id         INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                "  DATA      date, " +
                "  place       varchar(50), " +
                "  small_image varchar(50), " +
                "  big_image   varchar(50), " +
                "  is_likes    integer(1), " +
                "  description varchar(50));");
        db.execSQL("CREATE TABLE Record (" +
                "  _id        INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                "  record_uri varchar(100));");
        db.execSQL("CREATE TABLE Video (" +
                "  _id      INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                "  vieo_uri integer(10));");
        db.execSQL("CREATE TABLE Post_Video (" +
                "  Post_id  integer(10) NOT NULL, " +
                "  Video_id integer(10) NOT NULL, " +
                "  PRIMARY KEY (Post_id, " +
                "  Video_id), " +
                "  FOREIGN KEY(Video_id) REFERENCES Video(_id), " +
                "  FOREIGN KEY(Post_id) REFERENCES Post(_id));");
        db.execSQL("CREATE TABLE Post_Record (" +
                "  Post_id   integer(10) NOT NULL, " +
                "  Record_id integer(10) NOT NULL, " +
                "  PRIMARY KEY (Post_id, " +
                "  Record_id), " +
                "  FOREIGN KEY(Record_id) REFERENCES Record(_id), " +
                "  FOREIGN KEY(Post_id) REFERENCES Post(_id));");
        db.execSQL("CREATE TABLE Post_Note (" +
                "  Post_id integer(10) NOT NULL, " +
                "  Note_id integer(10) NOT NULL, " +
                "  PRIMARY KEY (Post_id, " +
                "  Note_id), " +
                "  FOREIGN KEY(Note_id) REFERENCES Note(_id), " +
                "  FOREIGN KEY(Post_id) REFERENCES Post(_id));");
        db.execSQL("CREATE TABLE Post_Image (" +
                "  Post_id  integer(10) NOT NULL, " +
                "  Image_id integer(10) NOT NULL, " +
                "  PRIMARY KEY (Post_id, " +
                "  Image_id), " +
                "  FOREIGN KEY(Image_id) REFERENCES Image(_id), " +
                "  FOREIGN KEY(Post_id) REFERENCES Post(_id));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
