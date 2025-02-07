package usecase;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import repository.UserRepository;

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
public final class FetchUsersUseCase_Factory implements Factory<FetchUsersUseCase> {
  private final Provider<UserRepository> userRepositoryProvider;

  public FetchUsersUseCase_Factory(Provider<UserRepository> userRepositoryProvider) {
    this.userRepositoryProvider = userRepositoryProvider;
  }

  @Override
  public FetchUsersUseCase get() {
    return newInstance(userRepositoryProvider.get());
  }

  public static FetchUsersUseCase_Factory create(Provider<UserRepository> userRepositoryProvider) {
    return new FetchUsersUseCase_Factory(userRepositoryProvider);
  }

  public static FetchUsersUseCase newInstance(UserRepository userRepository) {
    return new FetchUsersUseCase(userRepository);
  }
}
