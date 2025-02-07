package repository;

import api.ApiService;
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
public final class AuthRepositoryImpl_Factory implements Factory<AuthRepositoryImpl> {
  private final Provider<ApiService> apiServiceProvider;

  private final Provider<TokenDataSource> tokenDataSourceProvider;

  public AuthRepositoryImpl_Factory(Provider<ApiService> apiServiceProvider,
      Provider<TokenDataSource> tokenDataSourceProvider) {
    this.apiServiceProvider = apiServiceProvider;
    this.tokenDataSourceProvider = tokenDataSourceProvider;
  }

  @Override
  public AuthRepositoryImpl get() {
    return newInstance(apiServiceProvider.get(), tokenDataSourceProvider.get());
  }

  public static AuthRepositoryImpl_Factory create(Provider<ApiService> apiServiceProvider,
      Provider<TokenDataSource> tokenDataSourceProvider) {
    return new AuthRepositoryImpl_Factory(apiServiceProvider, tokenDataSourceProvider);
  }

  public static AuthRepositoryImpl newInstance(ApiService apiService,
      TokenDataSource tokenDataSource) {
    return new AuthRepositoryImpl(apiService, tokenDataSource);
  }
}
