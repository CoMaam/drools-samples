package net.comaam.drools.sample.kmodule;

import org.drools.core.base.RuleNameMatchesAgendaFilter;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class HelloWorldTest {
	static KieContainer kcontainer;
	static KieBase kbase;
	KieSession ksession;
	
	@BeforeClass
	public static void setUpTestClass() {
		kcontainer = KieServices.Factory.get().getKieClasspathContainer();
		kbase = kcontainer.getKieBase();
	}
	
	@Before
	public void setUpTestCase() {
		ksession = kbase.newKieSession();
	}
	
	@After
	public void tearDown() {
		ksession.dispose();
	}

	@Test
	public void test() {
		ksession.insert(new Fact("DRL"));
		ksession.insert(new Fact("DSL"));
		ksession.insert(new Fact("DecisionTable"));
		ksession.fireAllRules(new RuleNameMatchesAgendaFilter(".*DRL.*"));
	}

}
