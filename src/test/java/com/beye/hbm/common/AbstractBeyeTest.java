package com.beye.hbm.common;

import com.beye.hbm.config.AppConfig;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by MamaMia on 2/3/2017.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class} )
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public @interface AbstractBeyeTest {
}
