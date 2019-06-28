package com.example.modulmapper;

public class Module {

    private int _columnID;
    private String _moduleCode;
    private String _moduleTitle;
    private String _prescription;
    private int _credits;
    private int _year;

    public Module() {

    }

    public Module(String moduleCode, String moduleTitle, String prescription, int credits, int year) {
        this._moduleCode = moduleCode;
        this._moduleTitle = moduleTitle;
        this._prescription = prescription;
        this._credits = credits;
        this._year = year;
    }

    public int get_columnID() {
        return _columnID;
    }

    public int get_year() {
        return _year;
    }

    public void set_year(int _year) {
        this._year = _year;
    }

    public void set_columnID(int _columnID) {
        this._columnID = _columnID;
    }

    public String get_moduleCode() {
        return _moduleCode;
    }

    public void set_moduleCode(String _moduleCode) {
        this._moduleCode = _moduleCode;
    }

    public String get_moduleTitle() {
        return _moduleTitle;
    }

    public void set_moduleTitle(String _moduleTitle) {
        this._moduleTitle = _moduleTitle;
    }

    public String get_prescription() {
        return _prescription;
    }

    public void set_prescription(String _prescription) {
        this._prescription = _prescription;
    }

    public int get_credits() {
        return _credits;
    }

    public void set_credits(int _credits) {
        this._credits = _credits;
    }
}
