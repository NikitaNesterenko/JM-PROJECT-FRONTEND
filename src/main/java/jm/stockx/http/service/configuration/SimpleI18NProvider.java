package jm.stockx.http.service.configuration;

import com.vaadin.flow.i18n.I18NProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.MessageFormat;
import java.util.*;

@Component
@Slf4j
public class SimpleI18NProvider implements I18NProvider{

    public static final String RESOURCE_BUNDLE_NAME = "app";

    public static final java.util.Locale ENGLISH = new Locale("en");
    public static final java.util.Locale RUSSIA = new Locale("ru");

    private Map<String, ResourceBundle> localeMap;

    @PostConstruct
    private void initMap() {
        localeMap = new HashMap<>();

        for (final Locale locale : getProvidedLocales()) {
            final ResourceBundle resourceBundle = ResourceBundle.getBundle(RESOURCE_BUNDLE_NAME, locale);
            localeMap.put(locale.getLanguage(), resourceBundle);
        }
    }

    @Override
    public List<Locale> getProvidedLocales() {
        return Collections.unmodifiableList(Arrays.asList(ENGLISH, RUSSIA));
    }

    @Override
    public String getTranslation(String key, Locale locale, Object... objects) {
        String rawstring = null;
        try {
            rawstring = localeMap.get(locale.getLanguage()).getString(key);

            return MessageFormat.format(rawstring, objects);

        } catch (final MissingResourceException e) {
            log.warn(String.format("No translation found for key {%s}", key));
            return String.format("!{%s}", key);
        } catch (final IllegalArgumentException e) {
            e.printStackTrace();
            return rawstring;
        }
    }
}

