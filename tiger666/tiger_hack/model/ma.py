#!/usr/bin/env python
# coding=utf-8

# run tang > ./temp/input/{time}.txt (n_size_of_news_now )
# run huangrui > ./temp/input/{time}.txt  
# > huiming's ./model/fil9.bin & fil9.vec  
# > nn = 10 > ./temp/output/{time}.txt
# > huiming's > ./tools/kumo.jar > ./temp/output/{time}.png

# NewsCrawler {para}-| Filter {para} | WordCloud {para} 

#def write_result(result):
#    print("Start write result ...");
#    output = pd.read_csv('../input/sample_submission_1.csv');
#    
#    for c in output.columns[sub.columns != 'Id']:
#        output[c] = result;
#        
#    output.to_csv('output{}.csv'.format(datetime.now().strftime('%Y%m%d_%H%M%S')), index=False);
#    print("Finish ╮（￣▽￣）╭ ");

#python ../tigerhack/test.py ./tools/freeq-master/news 50 && cp -r ./tool/freeq-master/news/* ./database/all_news && python ./tools/freeq-master/freeq.py &&  python ./tools/freeq-master/filter.py && java -jar -Dlog4j.configuration=file:"./log4j.xml" ./tools/kumo.jar -i "./temp/output/output.txt" -o "./temp/output/output.png"
import time
import sched
import commands
from datetime import datetime
  
s = sched.scheduler ( time.time, time.sleep )  

def func_apply():
    #(status,output) = commands.getstatusoutput('python ../tigerhack/test.py > ./temp/output/1.txt && java -jar -Dlog4j.configuration=file:"./log4j.xml" ./tools/kumo.jar -i "./temp/output/1.txt" -o "./temp/output/output.png"')
    (s,o) = commands.getstatusoutput('')

def perform(inc):
    s.enter(inc,0,perform,(inc,))
    func_apply()

def mymain(inc=60):
#    (status,output) = commands.getstatusoutput('python -m SimpleHTTPServer')
#    print status,output
    s.enter(0,0,perform,(inc,))
    s.run()  

if __name__ == "__main__":
    mymain()



