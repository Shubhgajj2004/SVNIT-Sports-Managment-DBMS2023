package com.example.sspi.svnitsportsmanagment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.HashMap;

public class SQLHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "svnit_sports_app";

    //Table PLAYERS
    public static final String PLAYER_TABLE_NAME = "student";
    public static final String PLAYER_NAME = "name1";
    public static final String PLAYER_AGE = "age";
    public static final String PLAYER_ADM_NO = "admission_no";
    public static final String PLAYER_GENDER = "gender";
    public static final String PLAYER_DEPT = "department";
    public static final String PLAYER_YEAR = "stu_year";

    //Table TEAM
    public static final String TEAM_TABLE_NAME = "team";
    public static final String TEAM_NAME = "team_name";
    public static final String TEAM_ID = "team_id";
    public static final String TEAM_DEPT = "department";
    public static final String SPORTS_ID_F_TEAM = "sports_id";

    //Table SPORTS
    public static final String SPORTS_TABLE_NAME = "sport";
    public static final String SPORTS_ID = "sports_id";
    public static final String SPORTS_NAME = "sports_name";

    //Table SPORTS_PLAYERS
    public static final String SPORTS_PLAYER_TABLE_NAME = "sport_player";
    public static final String PLAYER_ADM_NO_F_PLAYER_SPORTS = "admission_no";
    public static final String SPORTS_ID_F_PLAYER_SPORTS = "sports_id";
    public static final String PLAYER_SPORTS_POINTS = "points";

    //Table PLAYERS_TEAM
    public static final String PLAYERS_TEAM_TABLE_NAME = "team_player";
    public static final String PLAYER_ADM_NO_F_PLAYERS_TEAM = "admission_no";
    public static final String TEAM_ID_F_PLAYERS_TEAM = "team_id";

    private HashMap map;
    private Context context;

    private static final int DATABASE_VERSION = 1;

    public SQLHelper(Context context_)
    {
        super(context_, DATABASE_NAME, null, DATABASE_VERSION);
        context = context_;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //create table queries
        String createPlayer = "create table student( name1 varchar (25), " +
                "admission_no varchar(8) PRIMARY KEY Check(admission_no regexp '^U[0-9]{2}[A-z]{2}[0-9]{3}$')," +
                "age smallint(3)," +
                "gender boolean," +
                "department varchar(15)," +
                "stu_year smallint(3)" +
                ");";
        String createSport = "create table sport(" +
                "sports_name varchar(20)," +
                "sports_id int primary key" +
                ");";
        String createTeam = "create table team(" +
                "team_name varchar(50)," +
                "team_id int primary key," +
                "department varchar(50)," +
                "sports_id int," +
                "foreign key (sports_id) references sport(sports_id)" +
                ");";
        String createSportPlayer = "create table sport_player( " +
                "    admission_no varchar(8) check (admission_no regexp '^U[0-9]{2}[A-z]{2}[0-9]{3}$'), " +
                "    sports_id int, " +
                "    points int, " +
                "    primary key (admission_no, sports_id), " +
                "    foreign key(admission_no) references student(admission_no), " +
                "    foreign key(sports_id) references sport(sports_id) " +
                "    );";
        String createTeamPlayer = "create table team_player( " +
                "team_id int, " +
                "admission_no varchar(8) Check(admission_no regexp '^U[0-9]{2}[A-z]{2}[0-9]{3}$'), " +
                "foreign key(team_id) references team(team_id), " +
                "foreign key(admission_no) references student(admission_no), " +
                "primary key (admission_no, team_id) " +
                ");";
        //insert values queries
        String insertPlayers = "insert into student values " +
                "('Deepak Sharma','U20EC020',22,true,'ECE',3), " +
                "('Punit Varma','U20CS017',22,true,'CSE',3), " +
                "('Dharmesh Joshi','U21ME020',22,true,'MECH',2), " +
                "('Harsh Thakkar','U22CH020',22,true,'CHEM',1), " +
                "('Rohan Sharma','U20CS024',22,true,'CSE',4), " +
                "('Neha Singh','U21EC020',23,false,'ECE',3)," +
                "('Ravi Kumar','U20ME019',22,true,'MECH',4), " +
                "('Sakshi Patel','U20CE022',23,false,'CIVIL',3), " +
                "('Aditya Sharma','U21EE023',22,true,'EE',2), " +
                "('Nikhil Singh','U20EC021',22,true,'ECE',4), " +
                "('Megha Verma','U21CS030',23,false,'CSE',4), " +
                "('Alok Gupta','U20CH016',21,true,'CHEM',3), " +
                "('Nidhi Singh','U20EE025',22,false,'EE',4), " +
                "('Rahul Verma','U21ME018',23,true,'MECH',3), " +
                "('Ananya Singh','U20EE026',22,false,'EE',3), " +
                "('Kunal Shah','U21ME021',23,true,'MECH',2), " +
                "('Manish Sharma','U20CE024',22,true,'CIVIL',4), " +
                "('Pooja Patel','U20EE030',22,false,'EE',4), " +
                "('Varun Gupta','U21CS035',23,true,'CSE',4), " +
                "('Aditi Sharma','U20EC023',22,false,'ECE',3), " +
                "('Siddharth Verma','U21ME024',23,true,'MECH',3), " +
                "('Priyanka Singh','U20CE025',22,false,'CIVIL',4), " +
                "('Rohit Agarwal','U21ME025',23,true,'MECH',4), " +
                "('Harshita Shah','U20CS029',22,false,'CSE',3)," +
                "('Kartik Verma','U21EE032',23,true,'EE',2), " +
                "('Saurabh Sharma','U20EC024',22,true,'ECE',4), " +
                "('Nidhi Verma','U21CH020',23,false,'CHEM',3), " +
                "('Aryan Gupta','U20CS030',22,true,'CSE',4), " +
                "('Akanksha Patel','U21EC026',23,false,'ECE',3), " +
                "('Sachin Patel','U22CE004',19,true,'CIVIL',2), " +
                "('Prachi Singh','U22EE004',19,false,'EE',1), " +
                "('Abhishek Sharma','U21EC005',20,true,'ECE',2), " +
                "('Nisha Verma','U22CS003',19,false,'CSE',1), " +
                "('Alok Gupta','U21ME003',20,true,'MECH',2), " +
                "('Vaishali Shah','U21CE004',20,false,'CIVIL',2), " +
                "('Kunal Singh','U22EE005',19,true,'EE',1), " +
                "('Divya Sharma','U21EC006',20,false,'ECE',2), " +
                "('Rahul Verma','U22CS004',19,true,'CSE',1), " +
                "('Sagar Gupta','U22ME003',19,true,'MECH',2), " +
                "('Anjali Patel','U21CE005',20,false,'CIVIL',2), " +
                "('Abhinav Singh','U21EE005',20,true,'EE',2), " +
                "('Jyoti Sharma','U22EC006',19,false,'ECE',1)," +
                "('Anuj Verma','U22CS005',19,true,'CSE',2), " +
                "('Sanjay Gupta','U22ME004',19,true,'MECH',1), " +
                "('Rashi Patel','U21CE006',20,false,'CIVIL',2), " +
                "('Vivek Singh','U21EE006',20,true,'EE',2), " +
                "('Shikha Sharma','U22EC007',19,false,'ECE',1), " +
                "('Deep Verma','U22CS006',19,true,'CSE',1), " +
                "('Akash Gupta','U21ME004',20,true,'MECH',2), " +
                "('Kavya Sharma','U21EE007',20,false,'EE',3), " +
                "('Nikhil Gupta','U20CH008',21,true,'CHEM',4), " +
                "('Vidhi Singh','U22ME007',19,false,'MECH',2), " +
                "('Rahul Patel','U21CH039',20,true,'CHEM',3), " +
                "('Ankita Verma','U22CS007',19,false,'CSE',1), " +
                "('Ravi Kumar','U20EC010',21,true,'ECE',4), " +
                "('Neha Shah','U22CE008',19,false,'CIVIL',2), " +
                "('Ankit Singh','U21EC011',20,true,'ECE',3), " +
                "('Sakshi Sharma','U20CH021',21,false,'CHEM',4), " +
                "('Amit Verma','U22ME009',19,true,'MECH',1), " +
                "('Riya Patel','U21CH013',20,false,'CHEM',3), " +
                "('Harsh Gupta','U22EE008',19,true,'EE',2), " +
                "('Ritu Singh','U20CS014',21,false,'CSE',4), " +
                "('Rahul Sharma','U21EC015',20,true,'ECE',3)," +
                "('Swati Verma','U22EE016',19,false,'EE',2);";
        String insertSports = "insert into sport values " +
                "('cricket',1), " +
                "('football',2), " +
                "('basketbll',3), " +
                "('volleyball',4);";
        String insertTeams = "insert into team values " +
                "\t('CSE Strikers', 1, 'CSE', 1), " +
                "    ('ME Thunderbolts', 2, 'ME', 1), " +
                "    ('CHEM Titans', 3, 'CHEM', 1), " +
                "    ('ECE Warriors', 4, 'ECE', 1), " +
                "    ('EE Mavericks', 5, 'EE', 1), " +
                "    ('Civil Hurricanes', 6, 'Civil', 1), " +
                "    ('Thunderbolts FC', 7, 'CSE', 2), " +
                "    ('Titans United', 8, 'ME', 2), " +
                "    ('Stallions United', 9, 'CHEM', 2), " +
                "    ('ECE Stunners', 10, 'ECE', 2), " +
                "    ('Royal FC', 11, 'EE', 2), " +
                "    ('Falcons United', 12, 'Civil', 2), " +
                "    ('CSE Lions', 13, 'CSE', 3), " +
                "    ('ME Panthers', 14, 'ME', 3)," +
                "    ('CHEM Wizards', 15, 'CHEM', 3), " +
                "    ('ECE Eagles', 16, 'ECE', 3), " +
                "    ('EE Sharks', 17, 'EE', 3), " +
                "    ('Civil Warriors', 18, 'Civil', 3), " +
                "    ('Tigers', 19, 'CSE', 4), " +
                "    ('Rhinos United', 20, 'ME', 4), " +
                "    ('Bulls', 21, 'CHEM', 4), " +
                "    ('Panthers', 22, 'ECE', 4), " +
                "    ('Eagles United', 23, 'EE', 4), " +
                "    ('Hurricanes', 24, 'Civil', 4);";
        String insertSportPlayer = "insert into sport_player values " +
                "('U20EC020',2,233), " +
                "('U20CS017',2,245), " +
                "('U21ME020',1,230), " +
                "('U22CH020',1,345), " +
                "('U20CS024',1,190), " +
                "('U21EC020',3,200), " +
                "('U20ME019',1,207), " +
                "('U20CE022',3,290), " +
                "('U21EE023',2,206), " +
                "('U20EC021',2,249)," +
                "('U21CS030',3,309), " +
                "('U20CH016',2,250), " +
                "('U20EE025',1,279), " +
                "('U21ME018',3,219), " +
                "('U20EE026',2,204), " +
                "('U21ME021',3,301), " +
                "('U20CE024',2,300), " +
                "('U20EE030',1,299), " +
                "('U21CS035',3,296), " +
                "('U20EC023',2,251), " +
                "('U21ME024',4,171), " +
                "('U20CE025',1,199), " +
                "('U21ME025',3,308), " +
                "('U20CS029',2,291), " +
                "('U21EE032',3,198), " +
                "('U20EC024',2,229), " +
                "('U21MT020',3,269), " +
                "('U20CS030',1,179), " +
                "('U21EC026',1,217), " +
                "('U22CE004',1,239), " +
                "('U22EE004',1,249)," +
                "('U21EC005',2,244), " +
                "('U22CS003',3,264), " +
                "('U21ME003',2,266), " +
                "('U21CE004',2,253), " +
                "('U22EE005',3,257), " +
                "('U21EC006',3,222), " +
                "('U22CS004',2,233), " +
                "('U22ME003',4,312), " +
                "('U21CE005',4,226), " +
                "('U21EE005',4,322), " +
                "('U22EC006',4,233), " +
                "('U22CS005',4,156), " +
                "('U22ME004',4,231), " +
                "('U21CE006',4,214), " +
                "('U21EE006',4,277), " +
                "('U22EC007',4,288), " +
                "('U22CS006',4,259), " +
                "('U21ME004',4,213)," +
                "('U21EE007',4,288), " +
                "('U20CH008',4,289), " +
                "('U22ME007',3,322), " +
                "('U21CH039',4,258), " +
                "('U22CS007',4,271), " +
                "('U20EC010',1,272), " +
                "('U22CE008',2,283), " +
                "('U21EC011',1,284), " +
                "('U20CH021',2,297), " +
                "('U22ME009',3,263), " +
                "('U21CH013',4,229), " +
                "('U22EE008',4,180), " +
                "('U20CS014',3,333), " +
                "('U21EC015',2,320), " +
                "('U22EE016',1,167);";
        String insertTeamPlayer = "insert into team_player values " +
                "(10,'U20EC020'), " +
                "(7,'U20CS017'), " +
                "(2,'U21ME020'), " +
                "(3,'U22CH020'), " +
                "(1,'U20CS024')," +
                "(16,'U21EC020'), " +
                "(2,'U20ME019'), " +
                "(18,'U20CE022'), " +
                "(11,'U21EE023'), " +
                "(10,'U20EC021'), " +
                "(13,'U21CS030'), " +
                "(9,'U20CH016'), " +
                "(5,'U20EE025'), " +
                "(14,'U21ME018'), " +
                "(11,'U20EE026'), " +
                "(14,'U21ME021'), " +
                "(12,'U20CE024'), " +
                "(5,'U20EE030'), " +
                "(13,'U21CS035'), " +
                "(10,'U20EC023'), " +
                "(20,'U21ME024'), " +
                "(6,'U20CE025'), " +
                "(14,'U21ME025'), " +
                "(7,'U20CS029'), " +
                "(17,'U21EE032'), " +
                "(10,'U20EC024'), " +
                "(12,'U21MT020'), " +
                "(1,'U20CS030'), " +
                "(4,'U21EC026'), " +
                "(6,'U22CE004'), " +
                "(5,'U22EE004'), " +
                "(10,'U21EC005'), " +
                "(13,'U22CS003'), " +
                "(8,'U21ME003'), " +
                "(12,'U21CE004')," +
                "(17,'U22EE005'), " +
                "(16,'U21EC006'), " +
                "(7,'U22CS004'), " +
                "(20,'U22ME003'), " +
                "(24,'U21CE005'), " +
                "(23,'U21EE005'), " +
                "(22,'U22EC006'), " +
                "(19,'U22CS005'), " +
                "(20,'U22ME004'), " +
                "(24,'U21CE006'), " +
                "(23,'U21EE006'), " +
                "(22,'U22EC007'), " +
                "(19,'U22CS006'), " +
                "(20,'U21ME004'), " +
                "(23,'U21EE007'), " +
                "(21,'U20CH008'), " +
                "(14,'U22ME007'), " +
                "(21,'U21CH039'), " +
                "(19,'U22CS007'), " +
                "(4,'U20EC010')," +
                "(12,'U22CE008')," +
                "(4,'U21EC011'), " +
                "(9,'U20CH021'), " +
                "(14,'U22ME009'), " +
                "(21,'U21CH013'), " +
                "(23,'U22EE008'), " +
                "(13,'U20CS014'), " +
                "(10,'U21EC015'), " +
                "(5,'U22EE016');";

        //Execute all of them
        db.execSQL(createPlayer);
        db.execSQL(createSport);
        db.execSQL(createTeam);
        db.execSQL(createSportPlayer);
        db.execSQL(createTeamPlayer);

        db.execSQL(insertPlayers);
        db.execSQL(insertSports);
        db.execSQL(insertTeams);
        db.execSQL(insertSportPlayer);
        db.execSQL(insertTeamPlayer);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
//        if(oldV == 1 && newV == 2) {
//            db.execSQL("");
//        }
    }

    public Cursor getAllTeamsFromSport(int s_id) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("select * from team t where sports_id = " + s_id + ";",null);
    }

    public Cursor getAllPlayersFromTeam(int t_id) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("select s.name1, s.admission_no from student s inner join team_player tp on s.admission_no = tp.admission_no and tp.team_id = " + t_id + ";",null);
    }

//    public Cursor getDeptId(String deptN) {
//        SQLiteDatabase db = this.getReadableDatabase();
//        return db.rawQuery("select " + DEPT)
//    }

    public Cursor getTeamIdFromSports(int sid) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("select team_id from team where sports_id = " + sid + ";",null);
    }
    public Cursor getTeamIdFromName(String teamN) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("select " + TEAM_ID + " from " + TEAM_TABLE_NAME + " where " + TEAM_NAME + " = '" + teamN + "';",null);
    }

    public Cursor getAllPlayersFromSport(int s_id) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("select distinct * from student s, sport_player sp  where s.admission_no = sp.admission_no and sp.sports_id = " + s_id + ";",null);
    }

    public Cursor getAllPlayersFromDept(String dept_name) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("select * from " + PLAYER_TABLE_NAME + " where " + PLAYER_DEPT + " = '" + dept_name + "';",null);
    }

    public Cursor getScoreOfPlayer(String adm_no) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("select avg(points) as avg_score from sport_player where admission_no = '" + adm_no + "' group by admission_no;",null);
    }
//
//    public void addTeamInSport(String t_name, String t_id, String t_dept, String s_id) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(TEAM_NAME,t_name);
//        values.put(TEAM_ID,t_id);
//        values.put(TEAM_DEPT,t_dept);
//        values.put(SPORTS_ID_F_TEAM,s_id);
//        db.insert(TEAM_TABLE_NAME, null, values);
//        db.close();
//    }

    public Cursor getSId(String s_name) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("select sports_id from sport where sports_name = '" + s_name + "'", null);
    }

    public long addPlayerInTeam(int tID, String admNo) {
//        insert into team_player values(5,'admission_no');
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TEAM_ID_F_PLAYERS_TEAM, tID);
        values.put(PLAYER_ADM_NO_F_PLAYERS_TEAM, admNo);
        long row = db.insert(PLAYERS_TEAM_TABLE_NAME, null, values);
        db.close();
        return row;
    }

    public long addPlayerInSport(String admNo, int sID, int score) {
//        insert into sport_player values('admission_no',sports_id,223);
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PLAYER_ADM_NO_F_PLAYER_SPORTS, admNo);
        values.put(SPORTS_ID, sID);
        values.put(PLAYER_SPORTS_POINTS, score);
        long row = db.insert(SPORTS_PLAYER_TABLE_NAME, null, values);
        db.close();
        return row;
    }

    public long addPlayer(String p_name, String p_id, String p_age, boolean p_gender, String p_dept, String p_year) {
//        insert into student values
//        ('player_name','admission_no',22,true,'branch',3);
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PLAYER_NAME,p_name);
        values.put(PLAYER_ADM_NO,p_id);
        values.put(PLAYER_AGE,p_age);
        values.put(PLAYER_GENDER,p_gender);
        values.put(PLAYER_DEPT,p_dept);
        values.put(PLAYER_YEAR,p_year);
        long row = db.insert(PLAYER_TABLE_NAME, null, values);
        db.close();
        return row;
    }

    public void deletePlayer(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "PRAGMA foreign_keys=ON;";
        db.execSQL(query); // Enable foreign key constraints for this connection

        String[] tableNames = {PLAYER_TABLE_NAME, PLAYERS_TEAM_TABLE_NAME, SPORTS_PLAYER_TABLE_NAME}; // List of tables to cascade delete from

        for (String tableName : tableNames) {
            String whereClause = "student_id = ?";
            String[] whereArgs = {String.valueOf(id)};
            db.delete(tableName, whereClause, whereArgs); // Cascade delete from each table
        }

        db.close();
    }

    public void deleteTeam(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "PRAGMA foreign_keys=ON;";
        db.execSQL(query); // Enable foreign key constraints for this connection

        String[] tableNames = {"students", "enrollments", "grades"}; // List of tables to cascade delete from

        for (String tableName : tableNames) {
            String whereClause = "student_id = ?";
            String[] whereArgs = {String.valueOf(id)};
            db.delete(tableName, whereClause, whereArgs); // Cascade delete from each table
        }

        db.close();
    }

//    public Cursor getPlayerProfile(int p_id) {
//        SQLiteDatabase db = this.getReadableDatabase();
//        return db.rawQuery("",null);
//    }

//    public boolean updatePlayerProfile() {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//    }

    public Cursor getTeamPlayerCount(int t_id) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("select t.team_name, count(s.admission_no) as number_of_players from student s inner join team_player tp on s.admission_no=tp.admission_no and tp.team_id = " + t_id + " inner join team t on tp.team_id = t.team_id;", null);
    }

    public Cursor getPlayersFromSportOrderedByPoints(int s_id) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("select distinct name1, points, s.admission_no, t.team_name from student s, sport_player sp, team t, team_player tp where s.admission_no = sp.admission_no and sp.sports_id = " + s_id + " and t.team_id = tp.team_id and sp.admission_no = tp.admission_no order by points desc;", null);
    }

    public Cursor getSportPlayedByPlayer(int p_id) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("select st.name1, s.sports_name from sport s, sport_player sp, student st where s.sports_id = sp.sports_id and st.admission_no = sp.admission_no and sp.admission_no = '" + p_id + "';",null);
    }

}
