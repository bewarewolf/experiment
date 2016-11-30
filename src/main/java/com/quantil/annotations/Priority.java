package com.quantil.annotations;

import java.lang.annotation.*;

import com.quantil.enums.TestPriority;

@Target(value=ElementType.METHOD)
@Retention(value= RetentionPolicy.RUNTIME)
public @interface Priority {

	TestPriority value();
}
