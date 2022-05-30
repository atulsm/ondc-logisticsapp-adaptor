package com.flipkart.logisticsadaptor.models.ekart.enums;

public class Unit {

    public enum Measurement {
        INCHES {
            @Override
            public Double getMultiplier() {
                return 2.54;
            }
        },
        CMS {
            @Override
            public Double getMultiplier() {
                return 1.0;
            }
        },
        METER {
            @Override
            public Double getMultiplier() {
                return 100.0;
            }
        },
        MILIMETERS {
            @Override
            public Double getMultiplier() {
                return 0.1;
            }
        };

        public abstract Double getMultiplier();
    }

    public enum Weight {
        KG {
            @Override
            public Double getMultiplier() {
                return 1.0;
            }
        },
        GMS {
            @Override
            public Double getMultiplier() {
                return 0.001;
            }
        },
        POUNDS {
            @Override
            public Double getMultiplier() {
                return 0.453592;
            }
        };

        public abstract Double getMultiplier();
    }
}

