package com.microsoft.cognitiveservices.speech.translation;
//
// Copyright (c) Microsoft. All rights reserved.
// Licensed under the MIT license. See LICENSE.md file in the project root for full license information.
//

import java.util.HashMap;
import java.util.Map;

//
// Copyright (c) Microsoft. All rights reserved.
// Licensed under the MIT license. See LICENSE.md file in the project root for full license information.
//

/**
  * Defines TranslationText result.
  */
public final class TranslationTextResult extends com.microsoft.cognitiveservices.speech.SpeechRecognitionResult
{
    // BUG: this is hack for making documentation going.
    public TranslationTextResult(com.microsoft.cognitiveservices.speech.internal.TranslationTextResult result) {
        super(result);
        
        _Translations = new HashMap<String, String>();

        com.microsoft.cognitiveservices.speech.internal.StdMapStringString imap = result.getTranslations();
        for (String key : imap) {
            _Translations.put(key, imap.get(key));
        }
    }

    /**
      * Presents the translation results. Each item in the dictionary represents translation result in one of target languages, where the key 
      * is the name of the target language, in BCP-47 format, and the value is the translation text in the specified language.
      * @return the current translation map.
      */
    public final Map<String, String> getTranslations() {
        return _Translations;
    }
    private Map<String, String> _Translations;
    
    /**
      * Returns a String that represents the speech recognition result.
      * @return A String that represents the speech recognition result.
      */
    @Override
    public String toString() {
        String text = "ResultId:" + getResultId() +
                      " Reason:" + getReason()  +
                      ", Recognized text:<" + getText() +
                      ">.\n"; 

        for(String key : _Translations.keySet()) {
            text += "    Translation in " + key + ": <" + _Translations.get(key) + ">.\n";
        }
        return text;
    }
}
