package usecase;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class FormatDateUseCase_Factory implements Factory<FormatDateUseCase> {
  @Override
  public FormatDateUseCase get() {
    return newInstance();
  }

  public static FormatDateUseCase_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static FormatDateUseCase newInstance() {
    return new FormatDateUseCase();
  }

  private static final class InstanceHolder {
    private static final FormatDateUseCase_Factory INSTANCE = new FormatDateUseCase_Factory();
  }
}
