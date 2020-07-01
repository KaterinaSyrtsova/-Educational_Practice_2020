public class Trunk {//ствол дерева
    Trunk prev;//предыдущий узел - корень
    String str;//строка отступов (уровень узла)

    Trunk(Trunk prev, String str) {
        this.prev = prev;
        this.str = str;
    }

    void showTrunk(Trunk p, int count) {//функция вывода связей дерева
        if (p == null)//если нет поддеревьев
            return;
        showTrunk(p.prev, count);//выводим предыдущий узел
        count++;//увеличиваем уровень
        System.out.print(p.str);//выводим отступы и связи
    }

    void printTree(BinaryTree.Node tree, Trunk prev, boolean isRight) {//функция выводит узлы дерева, вызывает функцию вывода связей
        if (tree == null)//пустое дерево
            return;
        String prev_str = "    ";//отступ по уровням (длина как для стрелки)
        Trunk tmp = new Trunk(prev, prev_str);//новая связь
        printTree(tree.right, tmp, true);//правое поддерево
        if (prev == null)//если нет предыдущего узла (предка) -> корень дерева
            tmp.str = "-->";//связь корня дерева
        else if (isRight) {//если правое поддерево
            tmp.str = ".-->";//связь правого поддерева
            prev_str = "   |";//в отступ по уровням добавляем черту (дерево идет вширь)
        }
        else {//в противном случае - левое поддерево
            tmp.str = "`-->";//левое поддерево
            prev.str = prev_str;//отступ по уровням не меняется
        }
        int count = 0;//уровень узла
        showTrunk(tmp, count);//выводим связи дерева - стебли
        System.out.println(tree.value);//выводим значение узла
        if (prev != null)//задаем строку отступов для узла, если есть поддеревья
            prev.str = prev_str;
        tmp.str = "   |";//в отступ по уровням добавляем черту (дерево идет вширь)
        printTree(tree.left, tmp, false);//левое поддерево
    }
}