package com.swiftsynclite;

import java.io.File;
import java.io.Serializable;
import java.nio.file.Paths;

public class Profile implements Serializable {

    private String profileName;
    private String localDirPath, masterDirPath;
    private Mode mode;

    public Profile(String localDir, String masterDir){
        this("unnamed profile",localDir,masterDir,Mode.DEFAULT);
    }
    public Profile(String name, String localDir, String masterDir, Mode mode){
        this.profileName = name;
        this.localDirPath = localDir;
        this.masterDirPath = masterDir;
        this.mode = mode;
    }

    public File getLocal(){
        File fetched = new File(localDirPath);
        return fetched;
    }

    public File getMaster(){
        File fetched = new File(masterDirPath);
        return fetched;
    }

    public String getProfileName(){
        return this.profileName;
    }

    public Mode getMode(){
        return this.mode;
    }
    void setMode(Mode mode){
        this.mode = mode;
    }

    public enum Mode {
        DEFAULT,
        SWIFTSYNC,
        NIO2;

        static String getDescription(Mode m){
            if(m==DEFAULT){
                return "Default desc";
            }
            if(m==NIO2){
                return "NIO2 desc";
            }
            if(m==SWIFTSYNC){
                return "SwiftSync desc";
            }
            return "not supported";
        }
    }

}
