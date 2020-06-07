package ch.unisg.ics.interactions.wot.td.affordances;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import ch.unisg.ics.interactions.wot.td.vocabularies.TD;

public class InteractionAffordanceTest {
  private String prefix = "http://example.org";
  private InteractionAffordance test_affordance;
  
  @Before
  public void init() {
    Form form1 = new Form.Builder("http://example.org/property1")
        .addOperationType(TD.readProperty.stringValue())
        .build();
    
    Form form2 = new Form.Builder("http://example.org/property2")
        .addOperationType(TD.writeProperty.stringValue())
        .build();
    
    test_affordance = new InteractionAffordance(Optional.of("My Affordance"), 
        Arrays.asList(prefix + "Type1", prefix + "Type2"), Arrays.asList(form1, form2));
  }
  
  @Test
  public void testHasFormForOperationType() {
    assertTrue(test_affordance.hasFormWithOperationType(TD.readProperty.stringValue()));
    assertTrue(test_affordance.hasFormWithOperationType(TD.writeProperty.stringValue()));
  }
  
  @Test
  public void testNoFormByOperationType() {
    assertFalse(test_affordance.hasFormWithOperationType("bla"));
  }
  
  @Test
  public void testHasSemanticType() {
    assertTrue(test_affordance.hasSemanticType(prefix + "Type1"));
  }
  
  @Test
  public void testHasNotSemanticType() {
    assertFalse(test_affordance.hasSemanticType(prefix + "Type0"));
  }
  
  @Test
  public void testHasOneSemanticType() {
    assertTrue(test_affordance.hasOneSemanticType(Arrays.asList(prefix + "Type0", 
        prefix + "Type1")));
  }
  
  @Test
  public void testHasNotOneSemanticType() {
    assertFalse(test_affordance.hasOneSemanticType(Arrays.asList(prefix + "Type3", 
        prefix + "Type4")));
  }
  
  @Test
  public void testHasAllSemanticTypes() {
    assertTrue(test_affordance.hasAllSemanticTypes(Arrays.asList(prefix + "Type1", 
        prefix + "Type2")));
  }
  
  @Test
  public void testHasNotAllSemanticTypes() {
    assertFalse(test_affordance.hasAllSemanticTypes(Arrays.asList(prefix + "Type1", 
        prefix + "Type2", prefix + "Type3")));
  }
  
  @Test
  public void testGetFirstFormForOperationType() {
    assertTrue(test_affordance.getFirstFormForOperationType(TD.readProperty.stringValue())
        .isPresent());
  }
  
  @Test
  public void testNoFirstFormForOperationType() {
    assertFalse(test_affordance.getFirstFormForOperationType(TD.invokeAction.stringValue())
        .isPresent());
  }
}
