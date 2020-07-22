#!/bin/bash

curl 'https://github.com/antoniocaia/kattis/tree/master/src/kattis' | tac | tac | pup '#js-repo-pjax-container' >source.html;

cat source.html | pup 'a[class="js-navigation-open link-gray-dark"] attr{href}' | grep "\S" | sed 's/ //g' >gitlinks;
cat source.html | pup 'a[class="js-navigation-open link-gray-dark"] text{}' | grep "\S" | sed 's/ //g' >javas;
cat source.html | pup 'a[class="link-gray"] text{}' | sed -e 's/\<Solved\>//g' | grep "\S" | sed 's/ //g' >id #Remove 'Solved' from the last commit description;

tr A-Z a-z <id >ids; #Uppercase to lowercase


echo "# Kattis Problems Java Solutions" >README.md;
echo "Problem ID | Solution | Difficulty" >>README.md;
echo "--- | --- |:-:" >>README.md;

paste ids gitlinks javas | while IFS="$(printf '\t')" read -r id link java; do
	dif=$(curl https://open.kattis.com/problems/$id | pup 'div[class="problem-sidebar sidebar-info"] > div:nth-child(3) > p:nth-child(4) > span text{}');
	echo "[$id](https://open.kattis.com/problems/$id) | [$java](https://github.com$link) | $dif" >>README.md
done

rm source.html
rm gitlinks
rm javas
rm id
rm ids

exit 0