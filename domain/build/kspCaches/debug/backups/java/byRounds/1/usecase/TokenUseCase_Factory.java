package usecase;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import repository.TokenRepository;

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
public final class TokenUseCase_Factory implements Factory<TokenUseCase> {
  private final Provider<TokenRepository> tokenRepositoryProvider;

  public TokenUseCase_Factory(Provider<TokenRepository> tokenRepositoryProvider) {
    this.tokenRepositoryProvider = tokenRepositoryProvider;
  }

  @Override
  public TokenUseCase get() {
    return newInstance(tokenRepositoryProvider.get());
  }

  public static TokenUseCase_Factory create(Provider<TokenRepository> tokenRepositoryProvider) {
    return new TokenUseCase_Factory(tokenRepositoryProvider);
  }

  public static TokenUseCase newInstance(TokenRepository tokenRepository) {
    return new TokenUseCase(tokenRepository);
  }
}
