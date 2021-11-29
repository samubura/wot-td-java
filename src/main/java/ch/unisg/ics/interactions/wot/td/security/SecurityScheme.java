package ch.unisg.ics.interactions.wot.td.security;

import java.security.Security;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class SecurityScheme {

  public static final String NOSEC = "nosec";
  public static final String BASIC = "basic";
  public static final String DIGEST = "digest";
  public static final String APIKEY = "apikey";
  public static final String BEARER = "bearer";
  public static final String PSK = "psk";
  public static final String OAUTH2 = "oauth2";

  private final String schemeName;
  private final Map<String, String> configuration;
  private final Set<String> semanticTypes;

  protected SecurityScheme(String schemeName, Map<String, String> configuration,
                           Set<String> semanticTypes) {
    this.schemeName = schemeName;
    this.configuration = configuration;
    this.configuration.put("scheme", schemeName);
    this.semanticTypes = semanticTypes;
  }

  /**
   * Gets the name of the security scheme (i.e. nosec, apikey, basic,
   * digest, bearer, psk, and oauth2).
   * @return the name of the security scheme
   */
  public String getSchemeName() {
    return schemeName;
  }

  /**
   * Gets the security configuration which can be used in security definitions
   * of a <code>Thing Description</code>.
   * @return the security configuration
   */
  public Map<String, String> getConfiguration() {
    return configuration;
  }

  public Set<String> getSemanticTypes() {
    return semanticTypes;
  }

  public static abstract class Builder<T extends SecurityScheme>{
    protected Map<String, String> configuration;
    protected Set<String> semanticTypes;


    protected Builder() {
      this.configuration = new HashMap<>();
      this.semanticTypes = new HashSet<>();
    }

    @SuppressWarnings("unchecked")
    public SecurityScheme.Builder<T> addConfiguration(Map<String, String> map) {
      this.configuration.putAll(map);
      return this;
    }

    @SuppressWarnings("unchecked")
    public SecurityScheme.Builder<T> addSemanticType(String type) {
      this.semanticTypes.add(type);
      return this;
    }

    @SuppressWarnings("unchecked")
    public SecurityScheme.Builder<T> addSemanticTypes(Set<String> type) {
      this.semanticTypes.addAll(type);
      return this;
    }

    public abstract T build();
  }
}
