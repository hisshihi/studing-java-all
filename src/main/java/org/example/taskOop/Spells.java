package org.example.taskOop;

public enum Spells implements Describable {
    FIRE_BALL("fire ball") {
        @Override
        public String getDescription() {
            return "This is simple fire ball";
        }
    },
    FREEZING("Freezing") {
        @Override
        public String getDescription() {
            return "Go to freezing all!";
        }
    },
    ICE_SPIKE("Ice Spike") {
        @Override
        public String getDescription() {
            return "Razor sharp and cold as ice, well that's ice";
        }
    },
    RAISING_THE_DEAD("Raising the Dead") {
        @Override
        public String getDescription() {
            return "Summon the army of the dead!";
        }
    };

    private String name;

    Spells(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
