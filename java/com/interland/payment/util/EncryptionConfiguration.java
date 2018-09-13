package com.interland.payment.util;

final class EncryptionConfiguration extends Encryption {
  public EncryptionConfiguration() {
    setEncryptionMode(4);
    setConfiguration("DEFAULT");
  }

  public EncryptionConfiguration(int mode) {
    setEncryptionMode(mode);
    setConfiguration("DEFAULT");
  }

  public EncryptionConfiguration(String applicationKey) {
    setEncryptionMode(4);
    setConfiguration(applicationKey);
  }

  public EncryptionConfiguration(int mode, String applicationKey) {
    setEncryptionMode(mode);
    setConfiguration("C." + applicationKey);
  }
}