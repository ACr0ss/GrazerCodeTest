package presentation;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import usecase.LoginUseCase;
import usecase.TokenUseCase;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation"
})
public final class LoginViewModel_Factory implements Factory<LoginViewModel> {
  private final Provider<LoginUseCase> loginUseCaseProvider;

  private final Provider<TokenUseCase> tokenUseCaseProvider;

  public LoginViewModel_Factory(Provider<LoginUseCase> loginUseCaseProvider,
      Provider<TokenUseCase> tokenUseCaseProvider) {
    this.loginUseCaseProvider = loginUseCaseProvider;
    this.tokenUseCaseProvider = tokenUseCaseProvider;
  }

  @Override
  public LoginViewModel get() {
    return newInstance(loginUseCaseProvider.get(), tokenUseCaseProvider.get());
  }

  public static LoginViewModel_Factory create(Provider<LoginUseCase> loginUseCaseProvider,
      Provider<TokenUseCase> tokenUseCaseProvider) {
    return new LoginViewModel_Factory(loginUseCaseProvider, tokenUseCaseProvider);
  }

  public static LoginViewModel newInstance(LoginUseCase loginUseCase, TokenUseCase tokenUseCase) {
    return new LoginViewModel(loginUseCase, tokenUseCase);
  }
}
