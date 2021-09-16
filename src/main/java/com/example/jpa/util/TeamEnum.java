package com.example.jpa.util;

public enum TeamEnum {
    BACKEND (0,"BACKEND","백엔드"),
    CLIENT(1,"CLIENT","클라이언트"),
    DESIGN(2, "DESIGN","디자인"),
    OPERATION (3,"OPERATION","운영"),
    PLANNING (4,"PLANNING","기획"),
    MARKETING (5,"MARKETING","마케팅"),
    SALES (6,"SALES","영업"),
    VIDEO (7,"VIDEO","영상"),
    HR (8,"HR","인사"),
    CEO (9,"CEO","대표")
    ;

    private final int index;
    private final String team;
    private final String teamName;

    TeamEnum(int index, String team, String teamName) {
        this.team = team;
        this.teamName = teamName;
        this.index = index;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getTeam(){
        return team;
    }

    public int getIndex(){
        return index;
    }

    public static TeamEnum valueOf(int index) {
        for (TeamEnum team : TeamEnum.values()) {
            if (team.index == index) {
                return team;
            }
        }

        return null;  // or throw exception
    }
}
