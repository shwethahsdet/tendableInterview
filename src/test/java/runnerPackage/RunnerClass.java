package runnerPackage;

import io.cucumber.junit.CucumberOptions;

@CucumberOptions(features= {"/featureFiles"},
tags="@Shwetha",
monochrome=true,
plugin= {"pretty","summary","html:target/htmlResults"}
)
public class RunnerClass
{
}