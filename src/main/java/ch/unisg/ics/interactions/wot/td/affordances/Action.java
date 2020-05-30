package ch.unisg.ics.interactions.wot.td.affordances;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import ch.unisg.ics.interactions.wot.td.schema.DataSchema;

/**
 * TODO: add javadoc
 * 
 * @author Andrei Ciortea
 *
 */
public class Action extends InteractionAffordance {
  // TODO: currently Schema just holds an RDF graph
  private Optional<DataSchema> input;
  
  // TODO: add outputschema, safe, idempotent
  
  protected Action(Optional<String> title, List<String> types, List<HTTPForm> forms, 
      Optional<DataSchema> input) {
    super(title, types, forms);
    
    this.input = input;
  }
  
  public Optional<DataSchema> getInputSchema() {
    return input;
  }
  
  public static class Builder extends InteractionAffordance.Builder<Action, Action.Builder> {
    private Optional<DataSchema> inputSchema;
    
    public Builder(List<HTTPForm> forms) {
      super(forms);
      
      this.inputSchema = Optional.empty();
    }
    
    public Builder(HTTPForm form) {
      this(new ArrayList<HTTPForm>(Arrays.asList(form)));
    }
    
    public Builder addInputSchema(DataSchema inputSchema) {
      this.inputSchema = Optional.of(inputSchema);
      return this;
    }
    
    public Action build() {
      return new Action(this.title, this.types, this.forms, inputSchema);
    }
  }
}
