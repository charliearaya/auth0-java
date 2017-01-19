package com.auth0.json.mgmt;

import com.auth0.json.JsonTest;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class EmailProviderCredentialsTest extends JsonTest<EmailProviderCredentials> {

    private static final String json = "{\"api_key\":\"key123\",\"api_user\":\"username\",\"accessKeyId\":\"id\",\"secretAccessKey\":\"secret\",\"region\":\"ar\",\"smtp_host\":\"host\",\"smtp_port\":1234,\"smtp_user\":\"usr\",\"smtp_pass\":\"pwd\"}";

    @Test
    public void shouldSerialize() throws Exception {
        EmailProviderCredentials credentials = new EmailProviderCredentials("key123");
        credentials.setApiUser("username");
        credentials.setAccessKeyId("id");
        credentials.setSecretAccessKey("secret");
        credentials.setRegion("ar");
        credentials.setSmtpHost("host");
        credentials.setSmtpPort(1234);
        credentials.setSmtpUser("usr");
        credentials.setSmtpPass("pwd");

        String serialized = toJSON(credentials);
        assertThat(serialized, is(notNullValue()));
        assertThat(serialized, is(equalTo(json)));
    }

    @Test
    public void shouldDeserialize() throws Exception {
        EmailProviderCredentials credentials = fromJSON(json, EmailProviderCredentials.class);

        assertThat(credentials, is(notNullValue()));
        assertThat(credentials.getApiKey(), is("key123"));
        assertThat(credentials.getApiUser(), is("username"));
        assertThat(credentials.getAccessKeyId(), is("id"));
        assertThat(credentials.getSecretAccessKey(), is("secret"));
        assertThat(credentials.getRegion(), is("ar"));
        assertThat(credentials.getSmtpHost(), is("host"));
        assertThat(credentials.getSmtpPort(), is(1234));
        assertThat(credentials.getSmtpUser(), is("usr"));
        assertThat(credentials.getSmtpPass(), is("pwd"));
    }
}