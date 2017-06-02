#! /bin/bash

git fetch
git fetch -p origin

testarray=( $(for branch in `git branch -r | grep -v HEAD`;do echo -e `git show --format="%cr" $branch | head -n 1` \\t$branch; done | grep months | awk '{print $4}') )
#echo ${testarray[@]}

echo -e "\n--------------------------------------------------------------"
echo "These branches will be deleted:"
echo -e "--------------------------------------------------------------\n"

for i in ${testarray[@]} ; do

      echo $i     #to confirm the entry

done

echo -e "\n--------------------------------------------------------------"
read -p "Are you sure you want to delete these branches (y/n):" -n 1 -r
echo -e "\n--------------------------------------------------------------"
if [ $REPLY = y ]; then
	origin="origin/"
    for i in ${testarray[@]} ; do

		git push origin --delete ${i#$origin}

	done
elif [ $REPLY = n ]; then
	echo -e "\nBranches not deleted."
else
	echo -e "\nUnknown option: " $REPLY
fi
