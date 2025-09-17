package com.palomar.pokemoninfoservice.cucumber;

import static io.cucumber.core.options.Constants.GLUE_PROPERTY_NAME;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SelectDirectories;
import org.junit.platform.suite.api.ConfigurationParameter;

/**
 * Autor: josue.palomar
 * Fecha de creación: 13/09/25
 */
@Suite
@SelectDirectories("src/test/resources/features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.palomar.pokemoninfoservice.cucumber")
@ConfigurationParameter(key = "cucumber.plugin", value = "html:target/cucumber-reports.html,junit:target/cucumber-junit.xml")
public class CucumberRunnerTest {
}