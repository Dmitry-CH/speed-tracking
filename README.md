# Speed Tracking

Внимание, приложение находится в разработке!!!

## Usage

Для разработки потребуется установить на вашу машину [leiningen](https://leiningen.org/), а также доп. инструменты [calva](https://calva.io/).

Для запуска проекта используется след. команда:

* запустить локально (fn main)

        $ lein run

* запустить в dev режиме (calva + repl)

        Ctrl + Alt + C Ctrl + Alt + J

        or

        lein update-in :dependencies conj '[nrepl,"0.9.0"]' -- update-in :plugins conj '[cider/cider-nrepl,"0.27.4"]' -- update-in '[:repl-options,:nrepl-middleware]' conj '["cider.nrepl/cider-middleware"]' -- with-profile dev repl :headless

        +

        Ctrl + Alt + C Ctrl + Alt + C

## Reference

[Описание project.clj](https://github.com/technomancy/leiningen/blob/stable/sample.project.clj)

[Top 10 Calva Commands](https://calva.io/commands-top10/)
