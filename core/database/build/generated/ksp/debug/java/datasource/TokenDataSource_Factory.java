package datasource;

import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.Preferences;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
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
public final class TokenDataSource_Factory implements Factory<TokenDataSource> {
  private final Provider<DataStore<Preferences>> dataStoreProvider;

  public TokenDataSource_Factory(Provider<DataStore<Preferences>> dataStoreProvider) {
    this.dataStoreProvider = dataStoreProvider;
  }

  @Override
  public TokenDataSource get() {
    return newInstance(dataStoreProvider.get());
  }

  public static TokenDataSource_Factory create(Provider<DataStore<Preferences>> dataStoreProvider) {
    return new TokenDataSource_Factory(dataStoreProvider);
  }

  public static TokenDataSource newInstance(DataStore<Preferences> dataStore) {
    return new TokenDataSource(dataStore);
  }
}
