(defproject coding "0.1.0-SNAPSHOT"
  :java-source-paths ["java"]
  :main HelloCv
  :plugins [[lein-auto "0.1.3"]]
  :auto {:default {:file-pattern #"\.(java)$"}}
  :repositories [["vendredi" "https://repository.hellonico.info/repository/hellonico/"]]
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [opencv/opencv "3.3.1"]
                 [opencv/opencv-native "3.3.1_4"]
                 ; [opencv/opencv-native "3.3.1" :classifier "osx"]
                 ; [opencv/opencv-native "3.3.1" :classifier "windows"]
                 ; [opencv/opencv-native "3.3.1" :classifier "linux"]
                 ])
