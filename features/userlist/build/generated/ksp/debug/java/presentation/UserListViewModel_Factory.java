package presentation;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import usecase.FormatDateUseCase;
import usecase.FetchUsersUseCase;

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
public final class UserListViewModel_Factory implements Factory<UserListViewModel> {
  private final Provider<FetchUsersUseCase> getUsersUseCaseProvider;

  private final Provider<FormatDateUseCase> formatDateUseCaseProvider;

  public UserListViewModel_Factory(Provider<FetchUsersUseCase> getUsersUseCaseProvider,
      Provider<FormatDateUseCase> formatDateUseCaseProvider) {
    this.getUsersUseCaseProvider = getUsersUseCaseProvider;
    this.formatDateUseCaseProvider = formatDateUseCaseProvider;
  }

  @Override
  public UserListViewModel get() {
    return newInstance(getUsersUseCaseProvider.get(), formatDateUseCaseProvider.get());
  }

  public static UserListViewModel_Factory create(Provider<FetchUsersUseCase> getUsersUseCaseProvider,
      Provider<FormatDateUseCase> formatDateUseCaseProvider) {
    return new UserListViewModel_Factory(getUsersUseCaseProvider, formatDateUseCaseProvider);
  }

  public static UserListViewModel newInstance(FetchUsersUseCase getUsersUseCase,
                                              FormatDateUseCase formatDateUseCase) {
    return new UserListViewModel(getUsersUseCase, formatDateUseCase);
  }
}
