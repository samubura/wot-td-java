package ch.unisg.ics.interactions.wot.td.io.json;

import ch.unisg.ics.interactions.wot.td.vocabularies.TD;

import javax.json.Json;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public final class JWot {

  public static final String WOT_CONTEXT = "https://www.w3.org/2019/wot/td/v1";


  public static final String BASE = "base";
  public static final String CONTEXT = "@context";

  public static final String TITLE = "title";
  public static final String DESCRIPTION = "description";

  public static final String PROPERTIES = "properties";
  public static final String OBSERVABLE = "observable";

  public static final String ACTIONS = "actions";
  public static final String INPUT = "input";
  public static final String OUTPUT = "output";
  public static final String SAFE = "safe";
  public static final String IDEMPOTENT = "idempotent";

  public static final String EVENTS = "events";

  public static final String SEMANTIC_TYPE = "@type";
  public static final String TYPE = "type";

  public static final String FORMS = "forms";
  public static final String TARGET = "href";
  public static final String METHOD = "htv:methodName";
  public static final String CONTENT_TYPE = "contentType";
  public static final String SUBPROTOCOL = "subprotocol";
  public static final String OPERATIONS = "op";

  public static final String SECURITY = "security";
  public static final String SECURITY_DEF = "securityDefinitions";

  public static final Map JSON_OPERATION_TYPES =
    Arrays.stream(new String[][] {
    {TD.readProperty, "readproperty" },
    {TD.writeProperty, "writeproperty" },
    {TD.invokeAction, "invokeaction" },
  }).collect(Collectors.toMap(kv -> kv[0], kv -> kv[1]));

}
