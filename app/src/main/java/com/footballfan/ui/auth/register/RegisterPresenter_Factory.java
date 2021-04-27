// Generated by Dagger (https://dagger.dev).
package com.footballfan.ui.auth.register;

import com.footballfan.domain.RegisterInteractor;
import dagger.internal.Factory;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class RegisterPresenter_Factory implements Factory<RegisterPresenter> {
  private final Provider<RegisterInteractor> registerInteractorProvider;

  public RegisterPresenter_Factory(Provider<RegisterInteractor> registerInteractorProvider) {
    this.registerInteractorProvider = registerInteractorProvider;
  }

  @Override
  public RegisterPresenter get() {
    return newInstance(registerInteractorProvider.get());
  }

  public static RegisterPresenter_Factory create(
      Provider<RegisterInteractor> registerInteractorProvider) {
    return new RegisterPresenter_Factory(registerInteractorProvider);
  }

  public static RegisterPresenter newInstance(RegisterInteractor registerInteractor) {
    return new RegisterPresenter(registerInteractor);
  }
}
