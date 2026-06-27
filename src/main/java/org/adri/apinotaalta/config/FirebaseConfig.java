package org.adri.apinotaalta.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;

@Configuration
public class FirebaseConfig {
    @Bean
    public FirebaseApp firebaseApp() throws IOException {
        GoogleCredentials credentials;

        String firebaseConfigBase64 = System.getenv("FIREBASE_SERVICE_ACCOUNT_BASE64");

        if (firebaseConfigBase64 != null && !firebaseConfigBase64.isBlank()) {
            byte[] decodedConfig = Base64.getDecoder().decode(firebaseConfigBase64);
            credentials = GoogleCredentials.fromStream(
                    new ByteArrayInputStream(decodedConfig)
            );
        } else {
            FileInputStream serviceAccount = new FileInputStream(
                    "src/main/resources/firebase-settings-acount.json"
            );
            credentials = GoogleCredentials.fromStream(serviceAccount);
        }

        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(credentials)
                .build();

        if (FirebaseApp.getApps().isEmpty()) {
            return FirebaseApp.initializeApp(options);
        }

        return FirebaseApp.getInstance();
    }
}
