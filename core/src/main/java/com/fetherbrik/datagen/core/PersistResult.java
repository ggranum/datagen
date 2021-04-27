package com.fetherbrik.datagen.core;

/**
 * @author Geoff M. Granum
 */
public class PersistResult<G, R> {

  public final G generated;
  public final R persisted;

  public PersistResult(G generated, R persisted) {
    this.generated = generated;
    this.persisted = persisted;
  }
}
 
