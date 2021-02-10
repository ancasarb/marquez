/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package marquez.db;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import marquez.UnitTests;
import org.flywaydb.core.Flyway;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

@Category(UnitTests.class)
public class FlywayFactoryTest {
  @Rule public MockitoRule rule = MockitoJUnit.rule();

  @Mock private DataSource source;

  @Test
  public void testBuild_overrideConnectRetries() {
    final int override = 2;
    final FlywayFactory factory = new FlywayFactory();
    factory.setConnectRetries(override);

    final Flyway flyway = factory.build(source);
    assertThat(flyway).isNotNull();
  }

  @Test
  public void testBuild_overrideInitSql() {
    final String override = "SET ROLE buendia;";
    final FlywayFactory factory = new FlywayFactory();
    factory.setInitSql(override);

    final Flyway flyway = factory.build(source);
    assertThat(flyway).isNotNull();
  }

  @Test
  public void testBuild_overrideGroup() {
    final boolean override = true;
    final FlywayFactory factory = new FlywayFactory();
    factory.setGroup(override);

    final Flyway flyway = factory.build(source);
    assertThat(flyway).isNotNull();
  }

  @Test
  public void testBuild_overrideInstalledBy() {
    final String override = "marquez";
    final FlywayFactory factory = new FlywayFactory();
    factory.setInstalledBy(override);

    final Flyway flyway = factory.build(source);
    assertThat(flyway).isNotNull();
  }

  @Test
  public void testBuild_overrideMixed() {
    final boolean override = true;
    final FlywayFactory factory = new FlywayFactory();
    factory.setMixed(override);

    final Flyway flyway = factory.build(source);
    assertThat(flyway).isNotNull();
  }

  @Test
  public void testBuild_overrideIgnoreMissingMigrations() {
    final boolean override = true;
    final FlywayFactory factory = new FlywayFactory();
    factory.setIgnoreMissingMigrations(override);

    final Flyway flyway = factory.build(source);
    assertThat(flyway).isNotNull();
  }

  @Test
  public void testBuild_overrideIgnoreIgnoredMigrations() {
    final boolean override = true;
    final FlywayFactory factory = new FlywayFactory();
    factory.setIgnoreIgnoredMigrations(override);

    final Flyway flyway = factory.build(source);
    assertThat(flyway).isNotNull();
  }

  @Test
  public void testBuild_overrideIgnorePendingMigrations() {
    final boolean override = true;
    final FlywayFactory factory = new FlywayFactory();
    factory.setIgnorePendingMigrations(override);

    final Flyway flyway = factory.build(source);
    assertThat(flyway).isNotNull();
  }

  @Test
  public void testBuild_overrideIgnoreFutureMigrations() {
    final boolean override = true;
    final FlywayFactory factory = new FlywayFactory();
    factory.setIgnoreFutureMigrations(override);

    final Flyway flyway = factory.build(source);
    assertThat(flyway).isNotNull();
  }

  @Test
  public void testBuild_overrideValidateOnMigrate() {
    final boolean override = true;
    final FlywayFactory factory = new FlywayFactory();
    factory.setValidateOnMigrate(override);

    final Flyway flyway = factory.build(source);
    assertThat(flyway).isNotNull();
  }

  @Test
  public void testBuild_overrideCleanOnValidationError() {
    final boolean override = true;
    final FlywayFactory factory = new FlywayFactory();
    factory.setCleanOnValidationError(override);

    final Flyway flyway = factory.build(source);
    assertThat(flyway).isNotNull();
  }

  @Test
  public void testBuild_overrideCleanDisabled() {
    final boolean override = true;
    final FlywayFactory factory = new FlywayFactory();
    factory.setCleanDisabled(override);

    final Flyway flyway = factory.build(source);
    assertThat(flyway).isNotNull();
  }

  @Test
  public void testBuild_overrideLocations() {
    final List<String> override = ImmutableList.of("override/migration");
    final FlywayFactory factory = new FlywayFactory();
    factory.setLocations(override);

    final Flyway flyway = factory.build(source);
    assertThat(flyway).isNotNull();
  }

  @Test
  public void testBuild_overrideEncoding() {
    final String override = StandardCharsets.UTF_16.name();
    final FlywayFactory factory = new FlywayFactory();
    factory.setEncoding(override);

    final Flyway flyway = factory.build(source);
    assertThat(flyway).isNotNull();
  }

  @Test
  public void testBuild_overrideTable() {
    final String override = "override_flyway_schema_history";
    final FlywayFactory factory = new FlywayFactory();
    factory.setTable(override);

    final Flyway flyway = factory.build(source);
    assertThat(flyway).isNotNull();
  }

  @Test
  public void testBuild_overrideTablespace() {
    final String override = "override_tablespace";
    final FlywayFactory factory = new FlywayFactory();
    factory.setTablespace(override);

    final Flyway flyway = factory.build(source);
    assertThat(flyway).isNotNull();
  }

  @Test
  public void testBuild_overridePlaceholderReplacement() {
    final boolean override = true;
    final FlywayFactory factory = new FlywayFactory();
    factory.setPlaceholderReplacement(override);

    final Flyway flyway = factory.build(source);
    assertThat(flyway).isNotNull();
  }

  @Test
  public void testBuild_overridePlaceholders() {
    final Map<String, String> override = ImmutableMap.of("${placeholder}", "override");
    final FlywayFactory factory = new FlywayFactory();
    factory.setPlaceholders(override);

    final Flyway flyway = factory.build(source);
    assertThat(flyway).isNotNull();
  }

  @Test
  public void testBuild_overridePlaceholderPrefix() {
    final String override = "<";
    final FlywayFactory factory = new FlywayFactory();
    factory.setPlaceholderPrefix(override);

    final Flyway flyway = factory.build(source);
    assertThat(flyway).isNotNull();
  }

  @Test
  public void testBuild_overridePlaceholderSuffix() {
    final String override = ">";
    final FlywayFactory factory = new FlywayFactory();
    factory.setPlaceholderSuffix(override);

    final Flyway flyway = factory.build(source);
    assertThat(flyway).isNotNull();
  }

  @Test
  public void testBuild_overrideSqlMigrationPrefix() {
    final String override = "M";
    final FlywayFactory factory = new FlywayFactory();
    factory.setSqlMigrationPrefix(override);

    final Flyway flyway = factory.build(source);
    assertThat(flyway).isNotNull();
  }

  @Test
  public void testBuild_overrideRepeatableSqlMigrationPrefix() {
    final String override = "W";
    final FlywayFactory factory = new FlywayFactory();
    factory.setRepeatableSqlMigrationPrefix(override);

    final Flyway flyway = factory.build(source);
    assertThat(flyway).isNotNull();
  }
}