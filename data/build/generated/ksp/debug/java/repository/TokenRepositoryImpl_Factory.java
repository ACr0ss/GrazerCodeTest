package repository;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import datasource.TokenDataSource;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class TokenRepositoryImpl_Factory implements Factory<TokenRepositoryImpl> {
  private final Provider<TokenDataSource> tokenDataSourceProvider;

  public TokenRepositoryImpl_Factory(Provider<TokenDataSource> tokenDataSourceProvider) {
    this.tokenDataSourceProvider = tokenDataSourceProvider;
  }

  @Override
  public TokenRepositoryImpl get() {
    return newInstance(tokenDataSourceProvider.get());
  }

  public static TokenRepositoryImpl_Factory create(
      Provider<TokenDataSource> tokenDataSourceProvider) {
    return new TokenRepositoryImpl_Factory(tokenDataSourceProvider);
  }

  public static TokenRepositoryImpl newInstance(TokenDataSource tokenDataSource) {
    return new TokenRepositoryImpl(tokenDataSource);
  }
}
