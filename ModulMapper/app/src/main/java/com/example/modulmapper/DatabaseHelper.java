package com.example.modulmapper;

import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.modulmapper.Module;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String TABLE_NETWORK = "networkCourses";
    public static final String TABLE_DATABASE = "databaseCourses";
    public static final String TABLE_SOFTWARE = "softwareCourses";
    public static final String TABLE_WEB = "webCourses";

    public static final String COLUMN_CODE = "code";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_PRESCRIPTION = "prescription";
    public static final String COLUMN_CREDITS = "credits";
    public static final String COLUMN_YEAR = "year";

    public String[][] year1 = {{"COMP501", "Information Technology Operations", "To enable students to apply fundamental IT technical support concepts and practice, and configure and administer systems and applications to meet organisational requirements", "15"},
            {"COMP502", "Fundamentals of Programming and Problem Solving", "To enable students to apply the principles of software development to create simple working applications and use problem-solving and decision-making techniques to provide innovative and timely Information Technology outcomes", "15"},
            {"INFO501", "Professional Practice", "To enable students to apply professional, legal, and ethical principles and practices in a socially responsible manner as an emerging IT professional, and apply communication, personal and interpersonal skills to enhance effectiveness in an IT role", "15"},
            {"INFO502", "Business Systems Analysis and Design", "The student will be able to apply the fundamentals of information systems concepts and practice to support and enhance organisational processes and systems; and apply the fundamentals of interaction design concepts and practice to enhance interface design", "15"},
            {"COMP503", "Introduction to Networks", "To enable students to apply a broad operational knowledge of networking, and associated services and technologies to meet typical organisational requirements", "15"},
            {"COMP504", "Operating Systems and System Supports", "To enable students to select, install, and configure IT hardware and systems software and use graphical (GUI) and command line interfaces (CLI) to meet organisational requirements", "15"},
            {"INFO503", "Database Principles", "To enable students to apply a broad operational knowledge of database administration to meet typical organisational data storage and retrieval requirements, and apply conceptual knowledge of cloud services and virtualisation", "15"},
            {"INFO504", "Technical Support", "To enable students to demonstrate an operational knowledge and understanding of IT service management, identify common issues related to IT security, and troubleshoot and resolve a range of common system problems", "15"}};

    public String[][] networkYear2 = {{"COMP601", "Object Oriented Programming", "To enable students to gain the skills to develop software applications using Object Oriented Programming techniques. Students will enrich their programming and problem solving skills by applying classes, objects, constructors, methods and properties, inheritance and polymorphism to develop programming applications", "15"},
            {"INFO601", "Database Modelling and SQL", "To enable students to apply an indepth understanding of database modelling, database design and SQL concepts", "15"},
            {"MATH601", "Mathematics for Information Technology", "To enable students to gain mathematical skills and acquire in-depth understanding of mathematics as applied to Information Technology", "15"},
            {"COMP602", "Web Development", "To enable students to gain the in depth knowledge and skills required to be able to write programs in web programming languages that solve various web programming tasks", "15"},
            {"INFO602", "Business, Interpersonal Communications and Technical Writing", "To enable students to develop an understanding of the principles and processes involved in effective interpersonal communication and technical writing used in managing client relationships", "15"},
            {"COMP615", "Data Centre Infrastructure", "To enable students to apply a broad operational knowledge of data centres and associated technologies to meet typical organisational requirements", "15"},
            {"INFO603", "Systems Administration", "To enable students to gain the skills and knowledge required to effectively plan, install and administer a Microsoft Windows Server", "15"},
            {"COMP604", "Routing and Switching Essentials", "To enable students to configure, troubleshoot and understand the operation of Routers, Routing Protocols, Switches and VLANs in a networking environment, and complete the Cisco Certified Network Associate 2 (CCNA2) Curriculum", "15"}};

    public String[][] networkYear3 = {{"COMP701", "Advanced Networking", "To enable students to investigate and configure advanced system administration tools, advanced network virtualisation and wireless networking technologies. Students will also research emerging networking technologies", "15"},
            {"INFO702", "Cyber-Security", "To enable students to investigate computer system attacks and vulnerabilities in relation to operating systems (OS), applications, networking and websites, and investigate the security techniques for protecting a computer system from such attacks", "15"},
            {"COMP702", "Scaling Networks", "To enable students to gain an understanding of the architecture, components, and operations of routers and switches in larger and more complex networks", "15"},
            {"COMP704", "Network Security", "To enable students to gain core security knowledge and skills needed for installation, troubleshooting, and monitoring of networks to maintain the integrity, confidentiality, and availability of data and devices", "15"},
            {"BIZM701", "Business Essentials for IT Professionals", "To enable students to develop an understanding of the common principles of business practice whilst focussing on the theoretical and practical concepts of accounting, marketing and management in order to understand the business context within which Information Technology solutions are developed", "15"},
            {"COMP705", "Connecting Networks", "To enable students to gain an understanding of Wide Area Network (WAN) technologies and network services required by converged applications in a complex network", "15"},
            {"COMP714", "Network Engineering Project", "To enable students to develop a Computer networking solution from a set of requirements documents. This module is the Network Engineering Capstone Project", "30"}};

    public String[][] databaseYear2 = {{"COMP601", "Object Oriented Programming", "To enable students to gain the skills to develop software applications using Object Oriented Programming techniques. Students will enrich their programming and problem solving skills by applying classes, objects, constructors, methods and properties, inheritance and polymorphism to develop programming applications", "15"},
            {"INFO601", "Database Modelling and SQL", "To enable students to apply an indepth understanding of database modelling, database design and SQL concepts", "15"},
            {"MATH601", "Mathematics for Information Technology", "To enable students to gain mathematical skills and acquire in-depth understanding of mathematics as applied to Information Technology", "15"},
            {"COMP602", "Web Development", "To enable students to gain the in depth knowledge and skills required to be able to write programs in web programming languages that solve various web programming tasks", "15"},
            {"INFO602", "Business, Interpersonal Communications and Technical Writing", "To enable students to develop an understanding of the principles and processes involved in effective interpersonal communication and technical writing used in managing client relationships", "15"},
            {"COMP605", "Data Structures and Algorithms", "To enable students to apply programming and analytical skills to implement and analyze common data structures for computer programs. Students will cover a wide range of computer programming algorithms", "15"},
            {"COMP606", "Web Programming", "To enable students to gain the in depth knowledge and skills required to be able to write programs in web programming languages that solve various web programming tasks", "15"},
            {"INFO604", "Database Systems", "To enable students to understand and discuss database systems, concepts, modelling, design and administration, and to apply theoretical and practical administrative tasks in a database administrator's role", "15"}};

    public String[][] databaseYear3 = {{"INFO704", "Data Warehousing and Business Intelligence", "To enable students to examine the main components of data warehousing and apply it to business intelligence applications, enabling them to provide solutions which incorporate extracting data from different sources, storing data in a data warehouse and developing applications for business decision-making", "15"},
            {"INFO706", "Database Front-End Applications", "To enable students to understand and apply various front end applications and their interfaces with supporting databases", "15"},
            {"COMP709", "Mobile Applications Development", "To enable students to design, develop and implement mobile applications on a given platform", "15"},
            {"INFO707", "Cloud Server Databases", "To enable students to gain an in-depth knowledge of cloud server database concepts, fundamentals and essentials. They will apply practical skills to install, setup, configure, manage and maintain a cloud server database and deploy cloud database services to support database applications", "15"},
            {"BIZM701", "Business Essentials for IT Professionals", "To enable students to develop an understanding of the common principles of business practice whilst focussing on the theoretical and practical concepts of accounting, marketing and management in order to understand the business context within which Information Technology solutions are developed", "15"},
            {"INFO703", "Big Data and Analytics", "To enable students to gain the practical knowledge and skills required to store, manage and analyse large amounts of data, using appropriate algorithms", "15"},
            {"INFO712", "Database Architecture Project", "To enable students to further develop their knowledge of Database Architecture by analysing, designing and implementing a database solution. This module is the Database Architecture Capstone Project", "30"},};

    public String[][] webYear2 = {{"COMP601", "Object Oriented Programming", "To enable students to gain the skills to develop software applications using Object Oriented Programming techniques. Students will enrich their programming and problem solving skills by applying classes, objects, constructors, methods and properties, inheritance and polymorphism to develop programming applications", "15"},
            {"INFO601", "Database Modelling and SQL", "To enable students to apply an indepth understanding of database modelling, database design and SQL concepts", "15"},
            {"MATH601", "Mathematics for Information Technology", "To enable students to gain mathematical skills and acquire in-depth understanding of mathematics as applied to Information Technology", "15"},
            {"COMP602", "Web Development", "To enable students to gain the in depth knowledge and skills required to be able to write programs in web programming languages that solve various web programming tasks", "15"},
            {"INFO709", "Human Computer Interaction", "To enable students to understand the supporting theories and principles of user interface design with respect to human computer interaction. They will investigate applications in human computer interaction and apply usability best practices and processes", "15"},
            {"INFO702", "Cyber-Security", "To enable students to investigate computer system attacks and vulnerabilities in relation to operating systems (OS), applications, networking and websites, and investigate the security techniques for protecting a computer system from such attacks", "15"},
            {"COMP709", "Mobile Applications Development", "To enable students to design, develop and implement mobile applications on a given platform", "15"},
            {"COMP710", "Web Application Development", "To enable students to apply practical knowledge of Model View Controller (MVC) frameworks to plan, design and implement web applications. The core focus will be on architecture design and implementation of a web application that will meet a set of functional requirements and user interface requirements, and address business models", "15"}};

    public String[][] webYear3 = {{"INFO709", "Human Computer Interaction", "To enable students to understand the supporting theories and principles of user interface design with respect to human computer interaction. They will investigate applications in human computer interaction and apply usability best practices and processes", "15"},
            {"INFO702", "Cyber-Security", "To enable students to investigate computer system attacks and vulnerabilities in relation to operating systems (OS), applications, networking and websites, and investigate the security techniques for protecting a computer system from such attacks", "15"},
            {"COMP709", "Mobile Applications Development", "To enable students to design, develop and implement mobile applications on a given platform", "15"},
            {"COMP710", "Web Application Development", "To enable students to apply practical knowledge of Model View Controller (MVC) frameworks to plan, design and implement web applications. The core focus will be on architecture design and implementation of a web application that will meet a set of functional requirements and user interface requirements, and address business models", "15"},
            {"BIZM701", "Business Essentials for IT Professionals", "To enable students to develop an understanding of the common principles of business practice whilst focussing on the theoretical and practical concepts of accounting, marketing and management in order to understand the business context within which Information Technology solutions are developed", "15"},
            {"INFO708", "Data Visualisation", "To enable students to study and apply visual techniques that transform data into a format efficient for human perception, cognition, and communication, thus allowing for extraction of meaningful information and insight. Students will investigate data visualisation techniques, human visual systems and cognitive perception, and design, construct, and evaluate data visualisations", "15"},
            {"COMP713", "Web Application Project", "To enable students to further develop their knowledge of Web Applications by analysing, designing and implementing a web solution. This module is the Web Application Capstone Project", "30"}};

    public String[] [] softwareYear2 = {{"COMP601", "Object Oriented Programming", "To enable students to gain the skills to develop software applications using Object Oriented Programming techniques. Students will enrich their programming and problem solving skills by applying classes, objects, constructors, methods and properties, inheritance and polymorphism to develop programming applications", "15"},
            {"INFO601", "Database Modelling and SQL", "To enable students to apply an indepth understanding of database modelling, database design and SQL concepts", "15"},
            {"MATH601", "Mathematics for Information Technology", "To enable students to gain mathematical skills and acquire in-depth understanding of mathematics as applied to Information Technology", "15"},
            {"COMP602", "Web Development", "To enable students to gain the in depth knowledge and skills required to be able to write programs in web programming languages that solve various web programming tasks", "15"},
            {"INFO602", "Business, Interpersonal Communications and Technical Writing", "To enable students to develop an understanding of the principles and processes involved in effective interpersonal communication and technical writing used in managing client relationships", "15"},
            {"COMP603", "The Web Environment", "To enable students to examine the working environment and applications that are used in the web industry", "15"},
            {"COMP605", "Data Structures and Algorithms", "To enable students to apply programming and analytical skills to implement and analyze common data structures for computer programs. Students will cover a wide range of computer programming algorithms", "15"},
            {"MATH602", "Mathematics for Programming", "To enable students to obtain the mathematical skills to facilitate an in-depth understanding of advanced programming techniques. Students will be able to solve problems in recurrence functions, asymptotic functions, algorithmic puzzles, combinatorics and graph theory and advanced topics in probability and statistics", "15"}};

    public String[][] softwareYear3 = {{"INFO701", "Project Management", "To enable students to understand and apply the theory of project management with particular emphasis on Information Technology projects", "15"},
            {"BIZM701", "Business Essentials for IT Professionals", "To enable students to develop an understanding of the common principles of business practice whilst focussing on the theoretical and practical concepts of accounting, marketing and management in order to understand the business context within which Information Technology solutions are developed", "15"},
            {"INFO703", "Big Data and Analytics", "To enable students to gain the practical knowledge and skills required to store, manage and analyse large amounts of data, using appropriate algorithms", "15"},
            {"COMP706", "Game Development", "To enable students to understand supporting theories and principles of game design and apply these to the art and science of game design, development and programming", "15"},
            {"INFO704", "Data Warehousing and Business Intelligence", "To enable students to examine the main components of data warehousing and apply it to business intelligence applications, enabling them to provide solutions which incorporate extracting data from different sources, storing data in a data warehouse and developing applications for business decision-making", "15"},
            {"COMP707", "Principles of Software Testing", "Students will gain comprehensive knowledge of software testing methodologies and software testing tools used in industry and apply fundamental aspects of software testing incorporating system requirements, quality assurance, testing processes, automation, testing types and testing levels. This forms the third part of the Software Engineering Capstone Project", "15"},
            {"COMP709", "Mobile Applications Development", "To enable students to design, develop and implement mobile applications on a given platform", "15"},
            {"COMP715", "Software Engineering Project", "Students will gain advanced software development skills. They will be able to provide an in depth analysis of prototyping, performance, correctness, software reusability, scalability and quality and maintenance and appropriate documentation. This module is the Software Engineering capstone project", "30"}};

    public DatabaseHelper(Context context) {
        super(context, "Login.db", null, 5);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table students(student_id text primary key, password text)");
        db.execSQL("Create table client(password text)");
        db.execSQL("Create table databaseCourses(id integer primary key autoincrement, " +
                "code text, " +
                "title text, " +
                "prescription text, " +
                "credits integer, " +
                "year integer)");
        db.execSQL("Create table networkCourses(id integer primary key autoincrement, " +
                "code text, " +
                "title text, " +
                "prescription text, " +
                "credits integer, " +
                "year integer)");
        db.execSQL("Create table softwareCourses(id integer primary key autoincrement, " +
                "code text, " +
                "title text, " +
                "prescription text, " +
                "credits integer, " +
                "year integer)");
        db.execSQL("Create table webCourses(id integer primary key autoincrement, " +
                "code text, " +
                "title text, " +
                "prescription text, " +
                "credits integer, " +
                "year integer)");

        addYear1(db);
        addNetworkYear2(db);
        addNetworkYear3(db);
        addDatabaseYear2(db);
        addDatabaseYear3(db);
        addWebYear2(db);
        addWebYear3(db);
        addSoftwareYear2(db);
        addSoftwareYear3(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists students");
        db.execSQL("Drop table if exists client");
        db.execSQL("Drop table if exists databaseCourses");
        db.execSQL("Drop table if exists networkCourses");
        db.execSQL("Drop table if exists softwareCourses");
        db.execSQL("Drop table if exists webCourses");
        onCreate(db);
    }

    public void addYear1(SQLiteDatabase db) {

        for (String[] entries : year1) {
            ContentValues values = new ContentValues();
            values.put(COLUMN_CODE, entries[0]);
            values.put(COLUMN_TITLE, entries[1]);
            values.put(COLUMN_PRESCRIPTION, entries[2]);
            values.put(COLUMN_CREDITS, entries[3]);
            values.put(COLUMN_YEAR, 1);

            try {
                db.insertOrThrow(TABLE_NETWORK, null, values);
            } catch (SQLiteConstraintException e) {
            }
        }

        for (String[] entries : year1) {
            ContentValues values = new ContentValues();
            values.put(COLUMN_CODE, entries[0]);
            values.put(COLUMN_TITLE, entries[1]);
            values.put(COLUMN_PRESCRIPTION, entries[2]);
            values.put(COLUMN_CREDITS, entries[3]);
            values.put(COLUMN_YEAR, 1);
            try {
                db.insertOrThrow(TABLE_DATABASE, null, values);
            } catch (SQLiteConstraintException e) {
            }
        }

        for (String[] entries : year1) {
            ContentValues values = new ContentValues();
            values.put(COLUMN_CODE, entries[0]);
            values.put(COLUMN_TITLE, entries[1]);
            values.put(COLUMN_PRESCRIPTION, entries[2]);
            values.put(COLUMN_CREDITS, entries[3]);
            values.put(COLUMN_YEAR, 1);
            try {
                db.insertOrThrow(TABLE_SOFTWARE, null, values);
            } catch (SQLiteConstraintException e) {
            }
        }

        for (String[] entries : year1) {
            ContentValues values = new ContentValues();
            values.put(COLUMN_CODE, entries[0]);
            values.put(COLUMN_TITLE, entries[1]);
            values.put(COLUMN_PRESCRIPTION, entries[2]);
            values.put(COLUMN_CREDITS, entries[3]);
            values.put(COLUMN_YEAR, 1);
            try {
                db.insertOrThrow(TABLE_WEB, null, values);
            } catch (SQLiteConstraintException e) {
            }
        }

    }

    public void addNetworkYear2(SQLiteDatabase db) {

        for (String[] entries : networkYear2) {
            ContentValues values = new ContentValues();
            values.put(COLUMN_CODE, entries[0]);
            values.put(COLUMN_TITLE, entries[1]);
            values.put(COLUMN_PRESCRIPTION, entries[2]);
            values.put(COLUMN_CREDITS, entries[3]);
            values.put(COLUMN_YEAR, 2);
            try {
                db.insertOrThrow(TABLE_NETWORK, null, values);
            } catch (SQLiteConstraintException e) {
            }
        }

    }

    public void addNetworkYear3(SQLiteDatabase db) {

        for (String[] entries : networkYear3) {
            ContentValues values = new ContentValues();
            values.put(COLUMN_CODE, entries[0]);
            values.put(COLUMN_TITLE, entries[1]);
            values.put(COLUMN_PRESCRIPTION, entries[2]);
            values.put(COLUMN_CREDITS, entries[3]);
            values.put(COLUMN_YEAR, 3);
            try {
                db.insertOrThrow(TABLE_NETWORK, null, values);
            } catch (SQLiteConstraintException e) {
            }
        }

    }

    public void addDatabaseYear2(SQLiteDatabase db) {

        for (String[] entries : databaseYear2) {
            ContentValues values = new ContentValues();
            values.put(COLUMN_CODE, entries[0]);
            values.put(COLUMN_TITLE, entries[1]);
            values.put(COLUMN_PRESCRIPTION, entries[2]);
            values.put(COLUMN_CREDITS, entries[3]);
            values.put(COLUMN_YEAR, 2);
            try {
                db.insertOrThrow(TABLE_DATABASE, null, values);
            } catch (SQLiteConstraintException e) {
            }
        }

    }

    public void addDatabaseYear3(SQLiteDatabase db) {

        for (String[] entries : databaseYear3) {
            ContentValues values = new ContentValues();
            values.put(COLUMN_CODE, entries[0]);
            values.put(COLUMN_TITLE, entries[1]);
            values.put(COLUMN_PRESCRIPTION, entries[2]);
            values.put(COLUMN_CREDITS, entries[3]);
            values.put(COLUMN_YEAR, 3);
            try {
                db.insertOrThrow(TABLE_DATABASE, null, values);
            } catch (SQLiteConstraintException e) {
            }
        }

    }

    public void addWebYear2(SQLiteDatabase db) {

        for (String[] entries : webYear2) {
            ContentValues values = new ContentValues();
            values.put(COLUMN_CODE, entries[0]);
            values.put(COLUMN_TITLE, entries[1]);
            values.put(COLUMN_PRESCRIPTION, entries[2]);
            values.put(COLUMN_CREDITS, entries[3]);
            values.put(COLUMN_YEAR, 2);
            try {
                db.insertOrThrow(TABLE_WEB, null, values);
            } catch (SQLiteConstraintException e) {
            }
        }

    }

    public void addWebYear3(SQLiteDatabase db) {

        for (String[] entries : webYear3) {
            ContentValues values = new ContentValues();
            values.put(COLUMN_CODE, entries[0]);
            values.put(COLUMN_TITLE, entries[1]);
            values.put(COLUMN_PRESCRIPTION, entries[2]);
            values.put(COLUMN_CREDITS, entries[3]);
            values.put(COLUMN_YEAR, 3);
            try {
                db.insertOrThrow(TABLE_WEB, null, values);
            } catch (SQLiteConstraintException e) {
            }
        }

    }

    public void addSoftwareYear2(SQLiteDatabase db) {

        for (String[] entries : softwareYear2) {
            ContentValues values = new ContentValues();
            values.put(COLUMN_CODE, entries[0]);
            values.put(COLUMN_TITLE, entries[1]);
            values.put(COLUMN_PRESCRIPTION, entries[2]);
            values.put(COLUMN_CREDITS, entries[3]);
            values.put(COLUMN_YEAR, 2);
            try {
                db.insertOrThrow(TABLE_SOFTWARE, null, values);
            } catch (SQLiteConstraintException e) {
            }
        }

    }

    public void addSoftwareYear3(SQLiteDatabase db) {

        for (String[] entries : softwareYear3) {
            ContentValues values = new ContentValues();
            values.put(COLUMN_CODE, entries[0]);
            values.put(COLUMN_TITLE, entries[1]);
            values.put(COLUMN_PRESCRIPTION, entries[2]);
            values.put(COLUMN_CREDITS, entries[3]);
            values.put(COLUMN_YEAR, 3);
            try {
                db.insertOrThrow(TABLE_SOFTWARE, null, values);
            } catch (SQLiteConstraintException e) {
            }
        }

    }

    public boolean insert(String student_id, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("student_id", student_id);
        contentValues.put("password", password);
        long ins = db.insert("students", null, contentValues);
        if(ins == -1) return false;
        else return true;
    }
    //check if student already exists
    public  boolean checkStudentID(String student_ID){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from students where student_id = ?", new String[]{student_ID});
        if(cursor.getCount()>0) return false;
        else return true;
    }

    //checking the email and password from the database
    public Boolean checkLoginDetails(String student_id, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from students where student_id=? and password = ?", new String[]{student_id, password});
        if(cursor.getCount()>0) return true;
        else return  false;
    }

    public ArrayList<Module> getModule(String table) {
        ArrayList<Module> modules = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String selectQuery = "SELECT * FROM " + table + ";";
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Module module = new Module();
                module.set_moduleCode(cursor.getString(1));
                module.set_moduleTitle(cursor.getString(2));
                module.set_prescription(cursor.getString(3));
                module.set_credits(cursor.getInt(4));
                module.set_year(cursor.getInt(5));
                modules.add(module);
            } while (cursor.moveToNext());
        }

        return modules;
    }

}
