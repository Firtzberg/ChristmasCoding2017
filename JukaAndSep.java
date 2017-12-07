/**
 *
 * @author hrvoje
 */
public class JukaAndSep {
    public static int solve1(String input) {
        byte[] bytes = input.getBytes();
        int repeating = 0;
        char previous = input.charAt(input.length() - 1);
        for (int i = 0; i< bytes.length;i++)
        {
            if (previous == input.charAt(i))
            {
                repeating += previous - '0';
                //System.out.println("At position " + i + " number " +previous + " repeats");
            }
            previous = input.charAt(i);
        }
        return repeating;
    }
    
    public static int solve2(String input) {
        int sum = 0;
        String[] lines = input.split("\n");
        for(String line : lines)
        {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (String numberTxt : line.split("\t"))
            {
                int value = Integer.parseInt(numberTxt.trim());
                if (min > value)
                    min = value;
                if (max < value)
                    max = value;
            }
            sum += max - min;
        }
        return sum;
    }
    public static int solve3(int input) {
        System.out.print(input + " gives ");
        int remaining = input -2;
        // length is the number of the square, ring, frame
        int length = 1;
        while (length * 2*4 < remaining)
        {
            remaining -= length*2*4;
            length++;
        }
        
        remaining %= length*2;
        
        // For some numers the result is right, for others not. We passed the challenge.
        if (remaining > length)
        {
            return remaining+1;
        }
        else
        {
            return 2*length - remaining-1;
        }
    }
    
    public static int solve4(String input){
        String[] passphases = input.split("\n");
        System.out.println(passphases.length);
        
        int counter =0;
        for(String passphase : passphases)
        {
            String[] words= passphase.split(" ");
            int wordIndex;
            for (wordIndex = 0;wordIndex<words.length;wordIndex++)
            {
                int wordIndex2;
                for (wordIndex2 = wordIndex+1;wordIndex2<words.length;wordIndex2++)
                {
                    if (words[wordIndex].equals(words[wordIndex2]))
                    {
                        break;
                    }
                }
                if (wordIndex2 < words.length)
                {
                    break;
                }
            }
            if (wordIndex == words.length)
            {
                counter ++;
            }
            else
            {
                
        System.out.println(passphase + " is wrong");
            }
        }
        return counter;
    }
    
    public static int solve5(String input){
        String[] nums = input.split("\n");
        int [] values = new int[nums.length];
        for(int i = 0; i < values.length; i++)
        {
            values[i] = Integer.parseInt(nums[i]);
        }
        int stepCount = 0;
        int instructionIndex = 0;
        while (instructionIndex >= 0 && instructionIndex < values.length)
        {
            instructionIndex += values[instructionIndex]++;
            stepCount++;
        }
        return stepCount;
    }
    

    public static void main(String[] args) {
        //System.out.println(solve1("1122"));
        //System.out.println(solve1("5994521226795838486188872189952551475352929145357284983463678944777228139398117649129843853837124228353689551178129353548331779783742915361343229141538334688254819714813664439268791978215553677772838853328835345484711229767477729948473391228776486456686265114875686536926498634495695692252159373971631543594656954494117149294648876661157534851938933954787612146436571183144494679952452325989212481219139686138139314915852774628718443532415524776642877131763359413822986619312862889689472397776968662148753187767793762654133429349515324333877787925465541588584988827136676376128887819161672467142579261995482731878979284573246533688835226352691122169847832943513758924194232345988726741789247379184319782387757613138742817826316376233443521857881678228694863681971445442663251423184177628977899963919997529468354953548612966699526718649132789922584524556697715133163376463256225181833257692821331665532681288216949451276844419154245423434141834913951854551253339785533395949815115622811565999252555234944554473912359674379862182425695187593452363724591541992766651311175217218144998691121856882973825162368564156726989939993412963536831593196997676992942673571336164535927371229823236937293782396318237879715612956317715187757397815346635454412183198642637577528632393813964514681344162814122588795865169788121655353319233798811796765852443424783552419541481132132344487835757888468196543736833342945718867855493422435511348343711311624399744482832385998592864795271972577548584967433917322296752992127719964453376414665576196829945664941856493768794911984537445227285657716317974649417586528395488789946689914972732288276665356179889783557481819454699354317555417691494844812852232551189751386484638428296871436139489616192954267794441256929783839652519285835238736142997245189363849356454645663151314124885661919451447628964996797247781196891787171648169427894282768776275689124191811751135567692313571663637214298625367655969575699851121381872872875774999172839521617845847358966264291175387374464425566514426499166813392768677233356646752273398541814142523651415521363267414564886379863699323887278761615927993953372779567675"));
        /*System.out.println(solve2("121	59	141	21	120	67	58	49	22	46	56	112	53	111	104	130 \n"+
"1926	1910	760	2055	28	2242	146	1485	163	976	1842	1982	137	1387	162	789\n" +
"4088	258	2060	1014	4420	177	4159	194	2794	4673	4092	681	174	2924	170	3548 \n"+
"191	407	253	192	207	425	580	231	197	382	404	472	164	571	500	216 \n"+
"4700	1161	168	5398	5227	5119	252	2552	4887	5060	1152	3297	847	4525	220	262 \n"+
"2417	992	1445	184	554	2940	209	2574	2262	1911	2923	204	2273	2760	506	157 \n"+
"644	155	638	78	385	408	152	360	588	618	313	126	172	220	217	161 \n"+
"227	1047	117	500	1445	222	29	913	190	791	230	1281	1385	226	856	1380 \n"+
"436	46	141	545	122	86	283	124	249	511	347	502	168	468	117	94 \n"+
"2949	3286	2492	2145	1615	159	663	1158	154	939	166	2867	141	324	2862	641 \n"+
"1394	151	90	548	767	1572	150	913	141	1646	154	1351	1506	1510	707	400 \n"+
"646	178	1228	1229	270	167	161	1134	193	1312	1428	131	1457	719	1288	989 \n"+
"1108	1042	93	140	822	124	1037	1075	125	941	1125	298	136	94	135	711 \n"+
"112	2429	1987	2129	2557	1827	477	100	78	634	352	1637	588	77	1624	2500 \n"+
"514	218	209	185	197	137	393	555	588	569	710	537	48	309	519	138\n"+
"1567	3246	4194	151	3112	903	1575	134	150	4184	3718	4077	180	4307	4097	1705"));*/
       // System.out.println(solve3(12) == 3);
       // System.out.println(solve3(23) == 2);
       // System.out.println(solve3(1024) == 31);
       // System.out.println(solve3(361527));
        
       
       /*System.out.println(
               solve4(
               "pphsv ojtou brvhsj cer ntfhlra udeh ccgtyzc zoyzmh jum lugbnk\n" +
"vxjnf fzqitnj uyfck blnl impo kxoow nngd worcm bdesehw\n" +
"caibh nfuk kfnu llfdbz uxjty yxjut jcea\n" +
"qiho qif eupwww avyglnj nxzotsu hio lws\n" +
"xjty usocjsh pivk qnknunc yjcgh bwya djw zpyr\n" +
"ycfmfe mgq sjiomg nfzjul bjwkmgu yvsnvgj dcjupu wzz blmn\n" +
"rdowgbt vpwfdoi blzl laghnk gsa vhnpo cztxzlb rtz hvwonhb eciju pfjtbo\n" +
"bqs bqs dbutvgf mmzb izpyud rap izpyud xlzeb mnj hjncs\n" +
"xpu vwp nujcos piu irindir tpmfd umtvlm gznu\n" +
"sfpuxar qcnbte omouazv cnh uaxspfr sepolf rusafpx\n" +
"xbmaf iceyqqq sabpt gliexel muubepe qqiyqce fmrcc eazk obkeonl fmccr kgk\n" +
"apg gbycwe gap pag\n" +
"gagv saqbk lwtllc wnhzz khxsjc\n" +
"lgc alen rlmsp anel gcbvg\n" +
"bujlaz rks rlqf deknmee yrp\n" +
"scqvl weusbc bgvaz vgg cjwsfno vqy zbq aqy tvf bgzav\n" +
"hbki vei fxdwljs myjuba elbsib pvy xxjxgi dtgv\n" +
"linzaeu qbwdke fdg pykw\n" +
"qvtdd aco aav bpu mvkcuc kjfj japgfki jfdl gem hog bdzsiea\n" +
"wpbigkb lzhwba jssjkn qvb kmwu qddv\n" +
"iny osyvqnt tumunzb torq bdeneg wywank poza ipp iggorw\n" +
"tuko mhdbsf vmjdop jomaqpj rcdsud hmgspr lsas nzmwc\n" +
"cirkjq nmjuu xtgejv gtexvj vjcmtqq unjmu\n" +
"xsdmezq xvqjvqp exhygy qahju hvd qadmdh lok\n" +
"wvvys kax rohrrar rwhnvi lhnmefp lsktouy bxilosp\n" +
"wayf diobnl zvu obnidl oibnld\n" +
"cewil ygsf ffzp ruxhu vah lnvwt aef lnnjc kgkb gxtlx feko\n" +
"uti epphrin pywths cpzzh csjei nczhamy gayxmb bdcytq xkx fgmt\n" +
"qvzyuwi dwo swkw bwjdrn dasgd ijgw vzabaop yefyhmc wgij\n" +
"dyg sugrf vid etz weyqg nyntx dwfgwm khon hnzzzn xfyra\n" +
"ofbh bdrsk rdrjj elaxvk jrjdr\n" +
"msxau rsocvx zxdda mxz lknl\n" +
"qktaywx dirpdbf unqnd wbrwkuu fvmqwl emxr big\n" +
"xwz kvsydc ayokjyy qiah omw neo htltxx fxhwqwj colqvbb sxmo ephfkex\n" +
"ncjxoaf fwjkc czmhv ylg axcjofn dvj bzqjku opvcr jiwzucg vmhzc\n" +
"gmmnrt zqar twdwrg qiwwki fcbr lixm hjdwwe moiva\n" +
"roinlxg cxeezve whannk cxeezve pyoj boweioy cpkgxsz\n" +
"qkct qso xlb xyy aellfet rzt cbboow devfb nih fhbfxzi\n" +
"qyc ltxia alixt atilx xtgrv\n" +
"svruz ufvo rvesnxv dik vzurs jjg idk\n" +
"xeudhrg hudn cilo ljplosb\n" +
"kpb oyzvywx vldko qhfkwod bkeutk zqcqug pbriu wqocos\n" +
"qkngzfy whobyri aze jvipdty ocirbep icqwc\n" +
"kzxxlab sjr zhymws xkbx\n" +
"nnxs gkwtld dwhkry snuibq dtdl aicug bhtlfzp qzk jctos\n" +
"regvro mxcq hqof yraucxi jhkol iuxineo pbtnk rfjwc szgjpr ndqqj vfgm\n" +
"yqrfox xoqrfy utbryu utubyr\n" +
"jdubjt wqrl wnk rlqw nwiq pnbn qinw uaff ftdo htfrav\n" +
"rum mur umr tij ovbahl losao imawwpb wadhww tbteyqc\n" +
"napxd kzeiqcp ppgqucm xkityt frq hugrp gjgtt gmuqppc zwqme\n" +
"xyuzs ysch howlzgu dkqppbs nvbiz mks mtxv vivouex uvawq\n" +
"ffe lfsn nlq mpulheq ikcfo wdtz cnwsbph zkib muu\n" +
"bqkxav wtecb lxwdhr kqbavx aqxvbk\n" +
"czwswqx ldkxapd pfwd bdkkj iqohla cwosw ihqpd pcc ckhabbn\n" +
"foiip hau rbqiyhh htm omeubgh symh evfcqg\n" +
"lqx xlq rsgf izu esetis\n" +
"npsrkdj fvulgkw eovw mzr uobcze azb tij ihoer ehori jit wknsqhm\n" +
"gnrksh xwggt oosi bpnmhx qqaa mpmryu jhzyz\n" +
"yad gbexqcr gbexqcr gbexqcr\n" +
"ldca xxhznn twyy ytwy zhxnnx xfmpi\n" +
"floioot kfyh dhibv ezyznar sfg sfg ezyznar\n" +
"cinioim iiocmin ypla aypl\n" +
"mhwcjbz dftuqsy wswop eizbf ptsd\n" +
"ehx mlh nfxgfkz uuw xftmn ptlkbo vsnyo ttwce\n" +
"oexvf orcg cncnkfk comvhl\n" +
"lqewsj lyulrcl efixd qvd fhznqnz yvrkwyi xmhgc vzbp\n" +
"dmr wrxqh thcm giomp rtvl ssc gwq rbklw hcmt fjvud\n" +
"teozhb dmzwfv qkq pvcqfqq\n" +
"hvlebc qqmg repxk zwrjdx ztruwb such tyligs ybg\n" +
"psa rqznokd lgc jstqres yiqt mbiody xazb xjuk dtb\n" +
"lea ncm rnh myzqzwm\n" +
"wjml eums ueflvbr cjpgnl qduunu zfxaai jwlm lprzzg vrn ttetyr sume\n" +
"uwkgeu uiahd plyewgi vveo nwhsitz mcitc uvk zsxehgs sewl\n" +
"lnbdrka sgtivn sozzq mgd vhxfnlr twrfpk\n" +
"gadphmk mbx lmlbrf tsnehnr lawdpm fnima gxgl\n" +
"umty vrn dpow fsnnpjv fsnvnjp nnsvpjf cioaio\n" +
"euu uue zeskmtk hob stekkzm\n" +
"ypqpri qwdju ypriqp iprqyp jnoxqa\n" +
"lkppi ingfxw wlulvp yhwrli nxwigf oyuhq ggfslx\n" +
"kdd ypvr pyvr waw vyrp khqq mamxca bapq gobfm\n" +
"iuq upvdpv zxef bfwns lmq lxswr kpsqo pwde iaaou nsw udy\n" +
"lgzo nil ovgrmt omgtrv jrqp pqrj lit\n" +
"uumyu iiakfj gvdtzz qbux yxn ejs dvlts\n" +
"hcm ghutxq zswi tmyhqef hgxtuq\n" +
"shkhkdk kad seubeax kdl mzu\n" +
"cpykgr skx rfhpor xsk moyhlai ogv ophfrr dxipuuh\n" +
"beyw jvrre opodn zdoajhx fhg ijs drczy drczy hjungq\n" +
"jrzieja gfg yzdn yxm wshibsn fgg\n" +
"xtylh vxscmvp rfymq uzhpyea spxcmvv dlni msj yxhlt\n" +
"eov awql miv miv eov\n" +
"mmvrfbg fjiyf hvqz zpuqmbf fszyuz ldfgni wemfjl fjjpl rbnpy rfb\n" +
"ppzpeh nam ntv xnchtyk hja hpepzp foj bibvx nmmdlff bsrkp\n" +
"qiy qiy umhlnh qiy\n" +
"tyds oepk wae tdsy sdty\n" +
"ukawr rkwau ghtjhm axy\n" +
"wtbjiv btjivw ewaf hwk ttq\n" +
"kdpun myve sqv rhvpy fnjwt puw ujhf thsp nkdadqr\n" +
"vyw wkkpdpy xlgz lmmcuve ncuq lmotk\n" +
"pmsfw vxd jpe qxlyasx ejp gwuv\n" +
"pmgyndm ezofbvx nicbwrw kwnlj yjvnas fdpkfo mqcsyhn pyjpf fbexvzo vkftm erl\n" +
"trmwvk rywuzoz hbidea kicohfz heidab deaibh\n" +
"sogf govd dknpk vxrvk rlm vwhjk\n" +
"xnxbfmw wguzrhd zbmkz piwppa mkbzz xvwrdgy flusfqb\n" +
"cgduq hbnwr xfx mrejb ckw zkbaihf cloow cwk wuvthv iwqctx\n" +
"vugx qbucd gxuv ocb cob\n" +
"ilmet fbelxxz qratdfn unoj hbc duv srmikz\n" +
"vnzuw zgpbqgf uzm thysyxd dinfh bgvr olungg ksd dsetwqz hpg\n" +
"omagsf zpr coa kknx bzithq pewp flvoz xiiq weojqr wpep\n" +
"aagj gcglqt gqcglt xbfx dhdx lbx\n" +
"pljq plxuscw ilh wfk lhi hli fouieyw\n" +
"hvnh zvm aqy dzitirm veq ctux\n" +
"lglhs aqibdii hjbn cfgc qrg pnbntcx owoks ebz\n" +
"jozngde lwne mbo omb fnyzvvj gndozje\n" +
"bbdgc igtdj uhahgp sqduko\n" +
"uuspedu fgnspm ewc slly jbs chl heanm abqijx kadvgxu\n" +
"akfsft skna kusjqr rkqujs\n" +
"erc vrljpu lruvjp lpvjur\n" +
"iors hcdr fsqtcj vop vmn dtqnz tov oscjlw cdrh ctfjsq lrnts\n" +
"fxp mczo sjlcxa mzoc jmsq hcxybow dmrr bcoxhyw\n" +
"aac ewraerq odmxpz aac aac\n" +
"zzio zebmxa szeej poordr gmi owwnnh xfx rzrab lfey jesze\n" +
"akc yyoj vqod drtne\n" +
"joxhvyf ymasnbr omouvq isxdrr\n" +
"qyi ayrkzu jsk vqvvno jkkuxi zufnnwu mrsszdf\n" +
"ocqi htfb tzjna cdt wkzhynm eergf\n" +
"yokzugl usyuqu qvotq uweqyow lygkzuo kpmqmb uglyzok\n" +
"glvshl imqv jrv xlpnsy gcg psj irtiamg wkl\n" +
"bjcpc nvyloa dkkan efj okubpc cxlowm eone kmpny\n" +
"cyxqys nmuaftv gqxj gtvsc\n" +
"beouh dioxiah kizdy hyi cozrray rave fqxmxmj gdm\n" +
"frjz amrsat lxvhzj azhevtu vxlzhj\n" +
"zwmnrk sbk txzrcsj sbk oosgfej cvh zuthibi onvwd sbk nhwpzq\n" +
"gzamt vraw kuk ugayl lyaug bww rwav ijah\n" +
"bdjirxg vifjr rhbxpa oao yrhjxoi pbn\n" +
"navb umesiys yhix phuhu aekkciu nlnsiq wjf idqdwp\n" +
"cmhw rsu urs ziprlfe\n" +
"kyhxitv cgty bnwjyq cygt sgjn pdab imarvhg yjbnqw\n" +
"axaa ejancv yau njpc jvwy bpft kwjvg qzrbvtm diu njpc bpft\n" +
"ambj upe rmqr yudbiqf krudp pqyf\n" +
"tnb mobnpv vep ohxoc cyip wxyccfo jrbi rwsws kls zlv oohxc\n" +
"fjh dmb hlbq bqc jhf kax suz fjjg rkpc\n" +
"wjnn byfirm goeyh xtjmdka\n" +
"tgyfxx hefpxln mveobqr yeo ftfn srt vim vlcu hevoi xtaaff\n" +
"imyql xotcl poql rlueapq bkwykm hlalk bkwykm\n" +
"gkec zff hbmtq rjxjbcf arerlu pvz cdaqi nijmhv uodwjh\n" +
"mpctof mopftc ksfbat sbkatf\n" +
"nvdd jub bvi kyggdbx nwtiok gjt mgsm dbhsn rzibgjm dvdn eqi\n" +
"ysd iirp dfgzza wiyeoou ysd ispkv bcqg wwzqgq xphse\n" +
"ntq ivposb gsd ezl tlkztp lez qyurp vxsmg dgs\n" +
"wijs rydbj onm usiyqzb hwrol giusanb kewukl yziuqbs doojam nom\n" +
"lfacyy xwwast truqtt tzneimn uxsydc ktu eqyaj ndszak\n" +
"ffleooc kikif fohgop aucy moubqxu\n" +
"iaxc pnwexdl ncy vmwm xrqoi wpgftq rofx utyzjuf stdxq twpgfq\n" +
"ppmlp etsvi cjdx poly ynx vfxpslg mqjo qnpsage flpsxvg jwsxiqt\n" +
"lbyhnb kflrpeq ssoti webxr embbjd kbnx ubzqco\n" +
"khhc vwuqzb ebocbko rwmonkz edfqn hzh qhncoq gbwdi wjeg ocwow\n" +
"ghzhd kcxblp lzwkkr gzhdh umk pblcxk\n" +
"wyajtw jiff ouylv sni lwhlrg avqjiis igzx wbl lhrwgl\n" +
"glhh kaxha tqii hwzx rgic kaxha rgyidmt qdgxfl ynjc oibfij\n" +
"bapj bix rjniw ynbql idlvnmt wynpzbl zlpuoix kvn kakwys\n" +
"aldpxxu iojxp rif xbyqtr jffdvy qnrq tqwsdiu\n" +
"ulssco ktbymjw bfj zhkg zgc ctyri\n" +
"ilrmq wfahcgk mrlqi bguad inj\n" +
"cjzc rekuy ifr wfkg sple\n" +
"cvjkp qbmumnp mprg ltmwxxh zpemtyb ozzssfd ksu mgrp\n" +
"nvc sxp mpkxz bhlctq hguaa yrdkm iwsgfg qjssh gobbies hucdh\n" +
"jdxrjw qmo qmo vobhnu\n" +
"dnjib wtjp rfdjqdj skpvrb vkwevb kxxovp\n" +
"fzi kicta zkuvr rfaawv ehklq cfdjsyb tukahwr zkuvr kicta ouq\n" +
"aba ytdguk gqmpn hvxabff hvxabff dckj\n" +
"fna wxyqhxd hvy khsu yypoyy lvvue medheua gim slf drdbeh ikihf\n" +
"jquz wwo wwo ghlz jrbvb jrbvb\n" +
"jwzvkl yjw ouwla yjw ouwla\n" +
"zsvlgyf rzqbtj qygynem ukdgjm lbsyh tmdzp fbcaim eymzr\n" +
"pvw sbs dvsa plmepl pwv ayxk vpw dwt\n" +
"inayadn pnti yzhxk azga gxq aznbciu gjnmyqm\n" +
"isgf ndqmk beyqq ebyqq srtzxo aiiw oqfuwp uoqwfp buejctv pxbk\n" +
"pzl irv tzvzdb wcy eszm ybwiw ycw riizifd iybww\n" +
"btpu cua azzqffy owcr\n" +
"ofwq sqlpzat lozdxlc aevjmpc lcolzxd wbbysn qwfo vcrx gdzgi\n" +
"dbpfmxu ydsxwl ijn svxtop csep ldqeog ffye zcrl soh aclw\n" +
"wyiyyhv vyhiywy obgi hiyywvy\n" +
"ddvaoc lhv spurn rgxyy onjw illvn yryxg xyyrg\n" +
"vid wdttqq kajr myip\n" +
"wolqlue phlunpt dcmmkfm sgxk dmmckmf sfng jlbsntq dxp\n" +
"zmneyho fswj xdgsjc oefwjdi htgxvbd tgqrq xodoa\n" +
"ynw bygqdnh hhmnkuw cojqrke qszzdjo orskwq mdfae asabn\n" +
"vvpm vkj pcxghao caoxphg axhblxb vvmp\n" +
"txox nzy eqn zgir dytsi girz ffa ugjjbzj brob fll\n" +
"kbz pukqbd fiwmuh umwihf bkz dvz\n" +
"vgs vejs vejs vejs mbkyjjy\n" +
"viqmnmu bitkyw nddnk dknnd cldnpp hipub plcdpn fdzzpb mmyomn\n" +
"ndylnfx gozlrx ngptk rnpteb wtacx xmtcjy xldha\n" +
"fey doyxis ampmtr ycqh syw cqhlj hnngx\n" +
"dijf nac tvkq ayo akbj lzmngdm wfxpn bpyvrf cvdqpa\n" +
"zsofz lhho hgat wqskga mnt\n" +
"mylwm zxsd omzpa waz hcrr lxmpq jsw sqtwak pzoma\n" +
"rwhgsgt ysdq ztihici mpwcawv alkqg wsxiwx\n" +
"snldn bcb anjdv cbb awsscc cqxult hjmjew mcycb fdpdg sesrh\n" +
"kukrqm fawafz qdim wyobtqx bnvjnqg dcvqxta yptr nnpu ughldqp duo zafwaf\n" +
"knb yjqb bscpnt nzg sqeu zkahna ttuf nsbtpc ixwit vucwj idix\n" +
"bfqyx xlnpc ijrxu zkqi kjxtahr fgag orusms adi bfqyx bfqyx\n" +
"dqddc ncbv bvfk hefikb dqddc hqjl otpx zfiu\n" +
"ntkv qunrzx eztzure ctt rjo bkdt znvd jwdf gqhf mmhrzgt\n" +
"zeavm hkbf rawqwuf pis dojlkt vnjhmi uvk cufmn qginezd xyut\n" +
"hnidzk chlctc yst pepd dxntbxg vqk daxfpmu wshyddl\n" +
"jgd vesqgo bdyqy igl ahstdm wjtd lrtkjsv tjsj sccxbih esn gkkzj\n" +
"iisiswh jll rhlaf jqwwgfa wmhyo izva vrg zjkak nlxxfer rvhx\n" +
"mkrkd jlqtpy ukstro ktuors wsj ynqpbp kpiyxzv nxeiwg xpzvkiy\n" +
"jbr gnct fwklekg cmfqnm ctn gqobrs kwht\n" +
"pztmjs yiffc kfhsblx yiffc yiffc\n" +
"biezil iiezbl bzeiil smocoju\n" +
"viiigm gmmmk yeiv dxzogro qsmzsur hukzwjn lcle syo mdj uruf rxfseu\n" +
"extchsd adeff ouikoj fyaclr rwwvqsd dooe tcxheds zrdqqhm fdoxv kbxi tlcj\n" +
"aycnydq qlxhka zoi shplo qll\n" +
"bfry lbwckm ltq rbfy gpn vojp ruj dpxcve geq\n" +
"svtvfwh lca lac qia vhwsftv nookdfz xgjiaf yvcdlt\n" +
"aspgqym fryuzhx bbydf tbn bwutsc fqgi zij lmxhog qnmse\n" +
"rbb gsys volnas onvlas lonasv vwjdso lnteapy\n" +
"got iauk kficn jvfuy yvoe jcxwui hyamqx mke mwh jcxwui hyamqx\n" +
"avutfi ggmha dkopc kothnnb syoi xsd wjedywy\n" +
"oziejyz yzeijoz hnthyn knj juuq qujtp kgq bymlnlf yicf\n" +
"zsejuy dybeap hvowmvn okxb yoi epadby cnzjk xfwprzc\n" +
"lacg iiix fblhxvf nrkkol lnafzw qspzsn gvdy ipj zub uouseo\n" +
"evukwkh ycjxxc lptwmf pmd izxdsos zrkavf pgjoy zwokg mpjiej\n" +
"vqw ijwoy eaw wvq svmcq ccxi nyub ynlq eqornax uprt pygfe\n" +
"plue okbbm btvm gba kutn jacjx ysqt lvx pcxxu qcf\n" +
"pyw ffjfudq bvk hsdwdva fjnivhf odbmw krpgrj\n" +
"hziesm bxa dceiwt tmvivjk snl fkh dahsxyx kqlhak lurtk\n" +
"xss sswyxrg yqff dbkx kbxd mpzbmnl bzplnmm\n" +
"uvz pjm ilrol pmj uzct ztcu brhkv\n" +
"heiz jcn syjt zfvlvaq aflvqvz amcjh rxnitw\n" +
"cxl nxvrn vjnz aewtr cxtko nnvcp ltptd adpxt zvjn fntklj\n" +
"aymmm tuirj hzngq zhbh paqs kvpfo aqsp kmo acprw sabrso kdqmp\n" +
"ndqjspv mmhp pndjsvq rti usm\n" +
"ije oad mvelyg jadz ekm dao zdcmv\n" +
"qwww tmwmdbb oxxfoza rgmf eonku brh gcgiuoi ojscn\n" +
"fjedeek ohlax fiydku rbnxpg wfivg cdgs\n" +
"axwbni hojye mwfe oyqknxp whdgfy ihku mbhr gagnz hehagxj\n" +
"hibautd blnayq lnayqb gepml mgpel qunw\n" +
"ircx oeb kujtip zbu ebo cmmn\n" +
"upyqvot wbponp hnn vav avv tvrky omm\n" +
"yzqsnf agbfsw dbxoya sfnqzy hqrxek qsnyzf oagyerm xxhukm\n" +
"xzvk mvcwz oujr hell hoe xexa dqlpqt xdqz ucola hsvv tcmybhl\n" +
"skldxr mzyol ybzyzd jnnxb rxncdy nkpwy fwlnsw omylz oiwieu fshv ngvha\n" +
"jkwqf yxrox hejfoq orxyx\n" +
"rijken xiwf mawqcfu erinjk jsi yyg mmu mdkfqb\n" +
"ornjes krp eornjs enjros pyqp nnwwjl\n" +
"wzd uqqo kyeli tikdle aykdjog uiz rbpnw mjxezf ihiz rlgyg\n" +
"cjm ajqgvkz kfgyy dmczlc mjc kxcm zctyqgh ymsk jwhqfd czpqgan\n" +
"vxkzvco owo qogj uyictoj kfr pyoo ejrru npluynx bvv jhhzu kuciwc\n" +
"eqk pcsly kelu arzgoe trfo fotr cuaax\n" +
"lagonw qvcssqz sdoklh uvovi sfrkmd hnvafj ltg wfjj\n" +
"viwbkm hpwe kzzwrbr axjtlq mznin wwpjg unlwur\n" +
"nuzorgo qfoz ydisca qxdfutv hzg\n" +
"nqgge tobtt hjocx ntyqyi rxzkynw wrnxzyk ciscy trjt ottbt\n" +
"yuii srawx gljxe eteogz kcu jlgxe tjik ktsnp agudqok jwol vfnyv\n" +
"vgicg dhnrmxz sjhozy hlalx rutwq\n" +
"nyoyoje kco hoyam hoyam tta iflud amh gdxcsj vqr fvsqcgv\n" +
"xdmbtph ueen cskerl rxjvpdc\n" +
"nricn addljzg obq rikez igq bxygkmv qmgojou uheubk qor\n" +
"snzd ztusvr vrstzu mceddga hgu\n" +
"vvrbfjg mcdhmsf ldtwl otuna gmjurrx jgrurxm rxmurjg yrioq\n" +
"iotkvo sftfvn vvoit lllju xvlg rdsb ywmdf mzxigu kzq\n" +
"sgqw gqsw lqfu wgqs xpiwou jurgucd azq wgaqpm\n" +
"ijntzi chlnfj yjqatz hjflcn vys ofq oqf oadthe jrfw\n" +
"mmc motjo vcwmod rpaszfk zgkkua bpja vjb htrk\n" +
"bpfvvka kmger mnvvfl hakudy yfprdoo mvnlfv rgmek evnwg\n" +
"mykpu juavkn cecdvi aszbi lxm hmps oaqoif\n" +
"fshizd fsdzhi lvcq hhpb eavwno auqlwz rpv owcdojx amsmf qgnddd\n" +
"pohmcn hlcxk qsesxh rncr\n" +
"fgyrsis ldem avxmnh frpodq oefzn\n" +
"plfpu qdyojz xdrzrjy kpv abkh fge bbnotvp liikmcu czvwl oyh\n" +
"ovha muitw pzy edfjoo fhsxuh dliyruc dikcd cqem ywfy\n" +
"exyry jtzqn tscr qbtxno cikk poqgr tnjzq eofe sxea anlikep kick\n" +
"zcie purpw dmhhms bcdo prwup uprpw wfejgjd\n" +
"kwtjc cmixp dodfwj hcgmmat pkeyspo ubnl ajxvj ffkh xvw\n" +
"nvlgq oduus psufiqg lrwpn dleftn xtllqvf usgz\n" +
"liarf sczsf sczsf wky qtzq qvve qvve\n" +
"cit vtjsh jrhkyvi txj urmq hppx\n" +
"rhblmxn rhblmxn lkgow dylurwc beyk gfcewxj ehpl disoe tjbjy lkgow\n" +
"nbkrm jvk ffux ars agns bebic jzjfm kmnbr gptvtsa ufxf\n" +
"hrlvup jaz tafyr qcgq wkd fiz bgsrx jmtcvo qkbvj\n" +
"eontk djf tiafrng mtwat puainel nyjoh meynxbf eqdw\n" +
"aspvmbx tgzuszm fpj xkl nzpr fjp vnomk byx sbtov tnu utn\n" +
"ldyww gwmiddv hwyh gcgsdit gtgdisc suufl xsw dlwyw\n" +
"sye dgbd wyf ixqzthx dgdb esy\n" +
"nsdgera fqz xwbdgui ngdgbcd bcn qrdxml cwcmxws tncm mqsodj cqgk\n" +
"estayas cocmbpv cdcf vygtswo aplwa estayas\n" +
"ndc ndc wntr sfls sfls\n" +
"gse svv esmi lcdii lnr kemrk gnk ildic blnqy wvn\n" +
"mwlpm awkr sxsudub yauwww hnktbog fpnqc nmxoq yoparu tqjpkug nbipft\n" +
"czwnkk hrodtmx yyzpil ooqjb cvxzfh\n" +
"kwa wak gipak gsgrw\n" +
"jyy fja jjk kuvoqdy urqx\n" +
"doyu chgn gvtxi qjdigvy kxr dizwrjc sll zenl yyblj\n" +
"epxeqih kfi hlog pakk kkiidrh hiufw wuhif baqzxzi bgcd phi jzjdxjp\n" +
"hllhyad sodc nyrtfe kygof hyyqi txddqg wcwxvnt ewqmj wwv\n" +
"vxymuoe caat diqwbo vfruxdf sqniefn hetcbl nvtttu ouesb\n" +
"yvoez pvthzc tdowuci wjijicn fhpmq kfobag yctdwj\n" +
"xaugkb rprkg tidpx pjk tpwwm pbcfhr wmwpt sfynrl iouaw zbnyu\n" +
"auakc culuxg bffg rodyhea ixlmtfb jdurl szoa\n" +
"xgona fjzho buh khbvti ddh mgj ptgaqps\n" +
"dqldupd udpldqd poku gfgpcg zsvk grvk kntx jih uwvxdvq sivk\n" +
"mwdnq wmqdn uzto mdqnw\n" +
"alvfm qxqo thwru xqqo jilnsgs rnonk fwntuby ogbha\n" +
"gvxlxyf cdpv khvpka kgt gshlaa tenb\n" +
"mtgvvxh mrjrsd truk rrerzx tujweaz\n" +
"ozepw gsqkr rtmmc cmrtm\n" +
"spnthg xhlzuu xwcrxz aqqejhh bpzh\n" +
"ectdftk rgp mkp vxp pevriz wkgfkaw vfygj peg gep wjn\n" +
"bksbu ywsszf tsbrps vxicr hfustju ynnlbo\n" +
"sio urbvf ujezjk vkyc ukjezj bvrfu qwwgqmw uqfekvx bzipxus qfumwh\n" +
"druru kycweog ycmef rjyy fkgp\n" +
"rmf ifbip rsztco coju wlr bfbmsug lwr bsufbgm nwmp\n" +
"jjuxtyd yif rkldsvu binq spepa mfg aszm\n" +
"ghilaau ncm sgbavz omzeotz azukf bgjw zqzo gjbw pld\n" +
"gtog iqheik budeu guvljmi\n" +
"qqlj jqql ttk xcxu\n" +
"cfq cfq kpagib dxfxufw hhksbjh gpcp\n" +
"xkeax acnia jjubfc mhot uxlhh gnkj pavta rciondm rkquh xudqian\n" +
"wqhqzg psqh rnnc uujlgq\n" +
"hpjpaoa maa rdndl xewqj nmagwx xewqj hxuyvou xziv rdndl fbxmbz hmfwghy\n" +
"dtwnrca hbfcptw qrmvat sdatx les zwizogq\n" +
"bodiwzg sgoas fsf wgkrn zgbdowi wfkz\n" +
"ngcsg grtao wcfxpyl gngcs fxwycpl fkpt\n" +
"txvngo vxngot tkoap zqjc qzcj oeruix myh ihgdfik qtt\n" +
"rxeh fcbnoo rxeh lve wvoc pmnxej dlcbrh rztt noibg\n" +
"zyvq lwxqu oyjv bvidmf wxuql\n" +
"wzc zcw czw dnhkvrg nzslrf\n" +
"cfgl uwhxu qnsfmt tgyabes mqnq nkitq hmcvxlt qqmn yzmb uomqp\n" +
"lwziur hgmdmv zuvipkp vir apr gfaq zeo dunat mqgafzg\n" +
"prq pqkr xlrw njf ncqni kgpoma cmtklv\n" +
"jwfuc poz opz fuple\n" +
"fgleub lcgnifu lkwo kftbc onvwvdx lukpod xgmh rnj\n" +
"rwqvv ezjmoni llq ekd cdvv kzcci gzsj vuipv fnw\n" +
"rtnua gbnzg kqtogns iozzwc kjpzz kiiurey yzlvzx cpy xrue\n" +
"fexcjmw ebwssx ewbcgwd uwolou nfdhic vupiykn jss djoo xftbkgo\n" +
"idf ipvmez qyevwd wfsjxja dif dig\n" +
"szpbtsa bssaztp sptzasb qppgz odur cpmn wpmg\n" +
"pxn zjmq rbnr azwstzm mln upaqyty nxp oge nlm\n" +
"bfaryqv hag phtvh ypi\n" +
"epeeog lip zqio wuehlnb bau sbd dsb\n" +
"xbrrp sej agrqnpa aarpnqg bnwyi jbn\n" +
"uqmsvd asmuyy czxviw pznnmvc\n" +
"sddwmek wnaea iwphupk sabo\n" +
"cingdks ksh mtyip zltgafm dflkcd wbdnqup uokm gmxpyd libz svv akce\n" +
"qge ewv dkabkmb xcpi nrkmsu mkmb djvamg mhhrwjh\n" +
"krjt etfhm bxzatw zdkvz ehov seyxbw mkiirs plzoplu sogmwb wodfcle\n" +
"qwea adibdp emo homrd pjcrhlc eqaw kqsrp rphjlcc\n" +
"gajzo nwjg qxjra jztcnir ijvjwez avxb afz zyywqz kcszgh elmlkfh\n" +
"lbz ozia bctf bumoji anhil rta xvit\n" +
"ejybire ypjl qevak fzalx mlh qxlei zib\n" +
"xmzas kwojjz ntrnrw nbmxlv mdgxs xjhxg suo zdcrxl qkujisz pxmu\n" +
"eezyd unrtm wyu vhufvto rpb isfcy ygh hgy\n" +
"nszvbzv ebtt memrsva ebtt qwcaq bhbas pvzfbov ppjbdy nszvbzv jabvrp\n" +
"rlo zbmi lugvu yeby\n" +
"tfcd tvl faaq mnural nyarh xnxk ctdf bodz\n" +
"vwdrhc gub bgu fpcovx rcvwhd jukwsue\n" +
"aekrhi lpknnrh bett tkib ioqrap igwnst aekrhi lhha\n" +
"acg mknhazp pcgjuk tajplv\n" +
"masq fyjkn agq qhxbbl qga npzj fme xtihic rntisg iqv aqg\n" +
"ipagh fjth mswztpi iexd cocojy vhqrla joe wrsrmw\n" +
"njztu tsh auqrxca zpp\n" +
"jctn webxi haq irrr qox irrr webxi\n" +
"reaw axmnvd voakf lnz ftbxfh zjyxzl pryfjpv sistgb pov mshs\n" +
"gsy ctsngl ptmnyx vpjx zpvtori pfu ioycdrq\n" +
"aobdtlj osdnrth sgqe geqs qegs\n" +
"oamrlxk ygbb rkamoxl nztl sarbmtj yqupjt plu sbtarmj vpa rxea\n" +
"yvhgp yznko epwpza gqrsod rilukp cglhomj wnaplu ugvdko qdr\n" +
"cggztg ajw gggzct ubmiefj kpa\n" +
"rel lvasbh kobm mdnzla pwnyj ehep gzx nhjdnsg rxa\n" +
"qaz gook rplqwh vsht\n" +
"dhe aneq ivrn awekad ckcbt zsqca ehd rvni oulwfuu\n" +
"oxgzzow wntz tkqaoi oxgzzow lwkdpgy lhd aekjasp tkqaoi dnhaw\n" +
"alxghco cpanoa onjh hyeyebe whxn zfu zozbll gojn\n" +
"zdqulsa dlqsazu zqudals sfedw\n" +
"rydtrsv rrtvysd fvyza drdgh lsfzt blnxr cnxe tslzf iijyds ylcxn\n" +
"cczea nxx kwol kopaza wuvr cyvoo whlicv\n" +
"zbmrwdq tlzbevx jwzpsc uvkwpd bmss rbzblj\n" +
"jogx jgi gji hypmtkg ijg oscjv\n" +
"flkoqja kwmrqv wzehel fvmcfap mkwqvr ivwxg jqfwdvo hweezl\n" +
"vgjg nzucho nuohcz ggvj tmxci\n" +
"fqaqx zeybhtg bxeic lftuqp wzuerz sww qfltxk\n" +
"keiy myrvp blkxcg lncqmsu diittlg fqrf digrel cpwrk ipan dkxb bymlzo\n" +
"owm irygdz pyhj mow wmo\n" +
"noul pbvvt zcv ueqyjl zhetlw lpjfhli\n" +
"felvwb wdykz kyibdz haq qkouj vuav oztyqh\n" +
"dyxo njcr hcuk ysrr pucw qbajztc\n" +
"ooyaz pmt hqwu gjx tmp tpm pwz\n" +
"lyhzajz dfot avyifo kdwka pwypcep kyyw tirlku zdpjmft\n" +
"aexle hfxo dacwvcy xsiotyg cifq ibupshj aktt rzvf pgafj\n" +
"pxubhw ibpm jxtxg iwnssf osbpj\n" +
"exmtfyx blbfg emrunru zkuhoi lfzn zrj unmcece phuppi\n" +
"icomb rmy mvsqqkh zwjubz lumq wekx\n" +
"cmdgs gsr pfhqx pfhqx cmdgs pga\n" +
"rpyf jejc adaiou dutv imbenyu dqw zhebjhu pryf vtxs yprf\n" +
"cxj roprjn rqoh qacagru snxd\n" +
"rczvi hfpl luc yowgj nvavlhw vjudkmv dwu teq\n" +
"klwc cktzh ksnvswl nsgeu xyohp mhs fxnjhm fwrcg rdeadkx cim\n" +
"ounvb vzqje ujctzzk iyy vxck ebtvbqr uswsmcr jveqz qejzv jmi pboq\n" +
"lwffygh mqsh vnnj ufz qhms gqfuxo lurzmu\n" +
"buf psdluck gapwoo wgll sbfavbc lljfvzx cdgo rpt sfvabcb\n" +
"svefr kubbri fervs nboi zkvq\n" +
"jwr vtc zkcpzb kczbzp cdned pzbzkc wigjuak fszgweu odflfek\n" +
"vwdqm khnnj plokjg vnce venc vecn yzxtgb\n" +
"tawl yrhoz tawl yrhoz\n" +
"vvehsl kdhzgme rix rcs btm pxnlsps vlhesv sxpnslp yqjtool\n" +
"eqpyw kpmkcyw wqhglxg ajfzo hbd qvmhy nhokah iisqvad kxuyd fxek\n" +
"jsz txhwhah hxt djnvl srylveu pxp dzmmn epek tzs\n" +
"joyzql jqczueb rtdyw fyc fjirfyn tjcalz joyzql fyc\n" +
"pjrmiz xwnmwns kcqjuut zfgxhdr octwn kqppg zhfgxrd wmwnnxs\n" +
"ema yqxqs aljjo ajloj wozb\n" +
"urgmhiz epqj vhhaxdm ptlsvig qzbmm cumbho lkg gyzmg eaopyzf ncfy mqe\n" +
"ijvwvo oszkees ugvyk hjdj ftip itfp\n" +
"ylfw qutzdj mgqp cyjss yzsdqqi iykvs fyor sthyqp mrjtzee hgo zwqbtgk\n" +
"bkfkns gco bykzc mje dwmkrwt ljegqor yxjxp oaleuu\n" +
"xeltq ggyqis aud frtyxhx iwz wiz fwoxz fozxw\n" +
"zdu nwduqsa nced iphaaxo\n" +
"bqjj oah ezd brhgxrc pmkz kdog exw\n" +
"ihatt hck iepn egemprp wrz wzcuo xjzeaa wku ivjvihh\n" +
"cwkuof bmj qmxd qbtms zgdei bsqmt ssndhw eeenku lcsqy bvvodr\n" +
"tek zsgytci vgoun kwwu\n" +
"jcxvp ijxc buqgix uil zfoku\n" +
"ggndshq bmjeo yqaxtik blspz yofh edaroy\n" +
"ipvtxh ouye elln dllvx iqza nhwf zyfw pvlky\n" +
"iydcx gvarm gvarm wegmiy\n" +
"sfjd liiflle mulboe qywzs tzbns trojl pad mnfcrhb sltb\n" +
"gthqj jvpsof jwlfyeg jwhlfj\n" +
"qckv umzrge gnzc mnr xde\n" +
"gvgxmhv txnait taxint ius iboqdj\n" +
"vsfex kbpvsby qembkb efxvs vhflzvm eaazg dyg bbmekq\n" +
"wxpfk xwfpk xwkpf cjsyi\n" +
"knzg eefq feqe seppop ttxz qnqfn atgsy cch mkjlbwt uyhct\n" +
"quzw jbiw miqehe qvf jyipqh kzcjxyh\n" +
"teuvzf tdtwoi pcuafa cwgjk ccur lgmqv jpjdkk efrnw uloqn dpkjkj lwloeph\n" +
"yaffjy xntstsv gygq sxttvsn tvnstxs\n" +
"cvbmdf pfrfkna wupv van iocb hsiyke obspj ytyfkl hbsqtij hkcw\n" +
"oeddmnu koso mdodeun ybe mhjbmwy ubejz soko yxvuv\n" +
"nylhy ylnyh olb vcdik\n" +
"gsp ilba llnu jjk urbvuma qzypf bkceotg ezxq hyvjngf\n" +
"tfnegyq rue waeif tfnegyq mvqm\n" +
"wvgnsk cpd oib wrdfaz kohwgkc kzzig hogkwck gkizz\n" +
"fecuuyp yfq bvanvxb cjeqwf unw dccr qzh zqu voakj\n" +
"utoazh bjuq kmhcre izmny mirorsy twnl jyoc\n" +
"fnnpd dmr ccgu eqgewc zuqivf\n" +
"kkxiba qdabuen oikaz dnuywmm\n" +
"aogud adugo uzcglpj lucv dgoua mdsqa mvrg\n" +
"lymhv sof hvyml mlvhy nit\n" +
"chu bwxp xpbw ghaix seklnc ola zofnrwt uch\n" +
"wtt abob vblijtd oabb qjws\n" +
"uozrpw kgf gxidxm uehdr fta pqakkrq atf fat woaolk\n" +
"gaee voshd ghlyy emvzlkg cmcgk tuwlsj jwtsul znrta mjieqph glker\n" +
"qiugxas gkg cbzmoz kahs obzzcm\n" +
"puz omcokz gjc heuqb\n" +
"dgndhb wid wdi scwnrjf juaisgo eivaw hgdndb\n" +
"mgcrd hnqg pkpeb vprxcp\n" +
"atlcnzp fyp cpkivxi bzj ypf cqpt bysu\n" +
"pnd jiitmzs csw mxnpck vxutdrs ivipzy cws xiegsy qut\n" +
"txlk avcvbuu hnq yyriq ajyswd urgiwc\n" +
"qgiqut gvblizs giqnfrk tty mvoj wpikl giqnfrk bkdpndu xztmxn hsmqxf\n" +
"llthg zjslki wilj rcyfois bavz hrqxn\n" +
"ytbw hlkl vip skycogy ejiirhx\n" +
"ndmtg bthlbw lsoq cvlvo sqol sqlo bppl sdkbls dtpyzrq vgm\n" +
"psm xpj xjp lqi spm gqirw aglpj\n" +
"htg fcchvyt xffev szdu lieadft\n" +
"nbjo qohgzu vofg vvild dbtyi pdolxn plnoao jxze xlpbxj brajzg\n" +
"urpp jjv lihmvp ivkwdqr sesyp ypbry qok sesyp ivkwdqr was\n" +
"yinepzv qvnzdtf apv ucxo bdioo juga hjfsyl hmowo avc\n" +
"dmiv tplae iiuiaxx tpale pyzkc\n" +
"giwhst mpexd byfyc swuzkc\n" +
"yydkwp xuu vjya kav ujmcxy qrtp zvlk\n" +
"lsvdyn tkw qxu omvlc wwmfvov mrgcoov dhpu tfair hupd zbx njzgwtw\n" +
"zuz rsxc xsrc gdwwf nycsv zzu kcu\n" +
"unlvzv jerqqgm nozma ykbflj qihqkx\n" +
"pctffo begf ivrvy ezru mvqt waocq\n" +
"tubtuk gxkc ikgw bjrird kxjebbh sbjyc yafkd khqajmt aclpmf gqfo yrpf\n" +
"rdt vrxa fyudo myeosb ursflwk\n" +
"wbjras edlbwdp ctobtw jbvtvcd xjgoo cmunxm mjtbpi klovx bypmsab unc\n" +
"xckml uztr htublq vilabvr jdiwus qejxur evfw qqm\n" +
"tzqq tzqq wkb wkb\n" +
"dgmg ljzc dgmg mbmco cgze qsap jccvot uors iiq\n" +
"rwvac woylk dmn teorprx nyuvz hcwwxlj lvej drbjo asjgq\n" +
"ljen tpfl vixcivr guaf lnje waim jlen\n" +
"djgaa janhi adudm yzv zkcb xqw fgvrz\n" +
"kpkjoon ggzx skp rqcsw xgzg zgxg jtf ghc\n" +
"rtnyxo qixfd nphekk mouzk gny fpzquw qgywx rpr gqydze\n" +
"gawdlv vrivoof rte iyp gaih sfzplm\n" +
"csojx wzojode uzy qulr lylmb guvtkwv\n" +
"ovxj aamms ftxo ebckdqw wqvsdci jwfqxks jafrcrn yyomrot\n" +
"qnu jqwr ywudxk qpsez rdc kiyfz iiecf dthxjjb bown\n" +
"typ zxcvjo rip acjhl paaab qhqipg xkguye sbxy pomkvn\n" +
"ofvaegv hgak oafevgv hkemar rqkha grklnsp msvkkku rekahm bxmjnw\n" +
"ahoihju sdyn phi uhz lupbx\n" +
"lavt jef klmq oqyfpf kis nazul ymezxek xpla fxyrfnt\n" +
"nwnagwy hvpjqfg sgm ungfstr gso owqqxjh\n" +
"hey hye ipyrt qxmthg jth wpbr hxgmtq cvfkfux qykdzhk movcfnl vxyoc\n" +
"zsras abnrj fgaczuk ssazr xzf cnxu gns wnqqy dwjh szars\n" +
"uhb zanlvh lvdotkb xekl kcofo\n" +
"lhx iccy ibkjw ciykxaj imsx ehamqlz iwzapxc rhaltv\n" +
"pofit owmpqej vwrobh jvox gdqehss yyxd styu tfkm fiotp\n" +
"ecz mdpoqsv mdpoqsv yxx rexok hcfll yvury hdhcfu juhkvpt rspnfj hxvgdir\n" +
"ohed mtigaoe eodh agmiteo\n" +
"vjvv hfco cppbxtw hawsjxz ovlsq qgs risgwhg auhj\n" +
"togivgg czrtvw ccz wzvtrc bse lsk\n" +
"ndc ndc lrfi iyleol nchx jxpv xdcsfmp nnx wtvq pih tgc\n" +
"hzpf sur zhfp klfmhx lbuidp xiqimnf\n" +
"qddpdk trfxpip pnsowj hidgvnf prur rsrautp aamykfm fysqjmq xwzjane mbmtxhf oqctt\n" +
"lfd eops govslp ultbye vrqai hcjkcf snpape\n" +
"cbok koumkad otpozb pqcs emilpe wpcyvxd bock\n" +
"spjb xkkak anuvk ejoklh nyerw bsjp zxuq vcwitnd xxtjmjg zfgq xkpf\n" +
"juo pmiyoh xxk myphio ogfyf dovlmwm moevao qqxidn"));*/
        System.out.println(
               solve5("0\n" +
"3\n" +
"0\n" +
"1\n" +
"-3"));
        System.out.println(
               solve5("0\n" +
"1\n" +
"0\n" +
"1\n" +
"0\n" +
"-1\n" +
"0\n" +
"1\n" +
"2\n" +
"2\n" +
"-8\n" +
"-7\n" +
"-3\n" +
"1\n" +
"0\n" +
"-2\n" +
"-6\n" +
"-7\n" +
"-11\n" +
"2\n" +
"-11\n" +
"0\n" +
"-18\n" +
"0\n" +
"-18\n" +
"-1\n" +
"1\n" +
"-16\n" +
"-3\n" +
"-28\n" +
"-10\n" +
"-6\n" +
"-11\n" +
"-6\n" +
"-17\n" +
"-20\n" +
"-15\n" +
"-31\n" +
"-37\n" +
"-34\n" +
"-14\n" +
"-35\n" +
"-34\n" +
"-17\n" +
"-28\n" +
"-20\n" +
"-12\n" +
"-41\n" +
"-29\n" +
"-8\n" +
"-1\n" +
"-50\n" +
"-46\n" +
"-26\n" +
"-41\n" +
"-33\n" +
"-17\n" +
"0\n" +
"-28\n" +
"-52\n" +
"-38\n" +
"-28\n" +
"-29\n" +
"-60\n" +
"-23\n" +
"-60\n" +
"-55\n" +
"-28\n" +
"-43\n" +
"-57\n" +
"-66\n" +
"-35\n" +
"-48\n" +
"-71\n" +
"-25\n" +
"-6\n" +
"-27\n" +
"-47\n" +
"-77\n" +
"-68\n" +
"-21\n" +
"2\n" +
"-39\n" +
"-82\n" +
"-2\n" +
"-59\n" +
"-61\n" +
"-67\n" +
"-26\n" +
"-11\n" +
"0\n" +
"-68\n" +
"-85\n" +
"-10\n" +
"-62\n" +
"-49\n" +
"-28\n" +
"-15\n" +
"-34\n" +
"-55\n" +
"-92\n" +
"-92\n" +
"-37\n" +
"-82\n" +
"-49\n" +
"-86\n" +
"-25\n" +
"-24\n" +
"-81\n" +
"-86\n" +
"-6\n" +
"-48\n" +
"-79\n" +
"-22\n" +
"-30\n" +
"-1\n" +
"-63\n" +
"-77\n" +
"-64\n" +
"-70\n" +
"-86\n" +
"-118\n" +
"-36\n" +
"-44\n" +
"-50\n" +
"-70\n" +
"-76\n" +
"-5\n" +
"-72\n" +
"-72\n" +
"-84\n" +
"-1\n" +
"-104\n" +
"-116\n" +
"-18\n" +
"-69\n" +
"-78\n" +
"-23\n" +
"-99\n" +
"-69\n" +
"-32\n" +
"-26\n" +
"-4\n" +
"-134\n" +
"-22\n" +
"-18\n" +
"-70\n" +
"-95\n" +
"-13\n" +
"-136\n" +
"-73\n" +
"-131\n" +
"-24\n" +
"-101\n" +
"-136\n" +
"-29\n" +
"-132\n" +
"-154\n" +
"-108\n" +
"-127\n" +
"-48\n" +
"-134\n" +
"-122\n" +
"-162\n" +
"-2\n" +
"-61\n" +
"-9\n" +
"-4\n" +
"-126\n" +
"-146\n" +
"-161\n" +
"-157\n" +
"-116\n" +
"-95\n" +
"-83\n" +
"-36\n" +
"-86\n" +
"-57\n" +
"-42\n" +
"-103\n" +
"-73\n" +
"1\n" +
"0\n" +
"-28\n" +
"-156\n" +
"-67\n" +
"-178\n" +
"-36\n" +
"-169\n" +
"-46\n" +
"-16\n" +
"-97\n" +
"-86\n" +
"-112\n" +
"-186\n" +
"-111\n" +
"-69\n" +
"-158\n" +
"-37\n" +
"-75\n" +
"-109\n" +
"-186\n" +
"-16\n" +
"-84\n" +
"-73\n" +
"-83\n" +
"-139\n" +
"-54\n" +
"-89\n" +
"-191\n" +
"-126\n" +
"-15\n" +
"-158\n" +
"-19\n" +
"-116\n" +
"-73\n" +
"-13\n" +
"-184\n" +
"-121\n" +
"-14\n" +
"-116\n" +
"-167\n" +
"-174\n" +
"-103\n" +
"-66\n" +
"-128\n" +
"-156\n" +
"-5\n" +
"-174\n" +
"-220\n" +
"-213\n" +
"-96\n" +
"-139\n" +
"-22\n" +
"-102\n" +
"-33\n" +
"-118\n" +
"-163\n" +
"-184\n" +
"-17\n" +
"-76\n" +
"-72\n" +
"-96\n" +
"-106\n" +
"-203\n" +
"-55\n" +
"-181\n" +
"-207\n" +
"-40\n" +
"-235\n" +
"-139\n" +
"-5\n" +
"-127\n" +
"-21\n" +
"-155\n" +
"-183\n" +
"-51\n" +
"-54\n" +
"-38\n" +
"-247\n" +
"-218\n" +
"-56\n" +
"-34\n" +
"-173\n" +
"-241\n" +
"-187\n" +
"-38\n" +
"-13\n" +
"-172\n" +
"-2\n" +
"-235\n" +
"-167\n" +
"-191\n" +
"-250\n" +
"-150\n" +
"-34\n" +
"-151\n" +
"-183\n" +
"-119\n" +
"-90\n" +
"-21\n" +
"-93\n" +
"-275\n" +
"-168\n" +
"-160\n" +
"-97\n" +
"-100\n" +
"-25\n" +
"-273\n" +
"-245\n" +
"-44\n" +
"-223\n" +
"-201\n" +
"-156\n" +
"-12\n" +
"-55\n" +
"-189\n" +
"-181\n" +
"-10\n" +
"-92\n" +
"-152\n" +
"-90\n" +
"-217\n" +
"-68\n" +
"-81\n" +
"-76\n" +
"-86\n" +
"-48\n" +
"-287\n" +
"-281\n" +
"-63\n" +
"-83\n" +
"-66\n" +
"-50\n" +
"-49\n" +
"-310\n" +
"-254\n" +
"-121\n" +
"-294\n" +
"-132\n" +
"-53\n" +
"-30\n" +
"-223\n" +
"-85\n" +
"-297\n" +
"-264\n" +
"-58\n" +
"-51\n" +
"-294\n" +
"-283\n" +
"-3\n" +
"0\n" +
"-262\n" +
"-33\n" +
"-136\n" +
"-14\n" +
"-238\n" +
"-6\n" +
"-312\n" +
"-17\n" +
"-328\n" +
"-299\n" +
"-245\n" +
"-266\n" +
"-6\n" +
"-330\n" +
"-117\n" +
"-172\n" +
"-260\n" +
"-224\n" +
"-139\n" +
"-156\n" +
"-165\n" +
"-13\n" +
"-243\n" +
"-173\n" +
"-42\n" +
"-67\n" +
"-7\n" +
"-148\n" +
"-1\n" +
"-105\n" +
"-205\n" +
"-223\n" +
"-122\n" +
"-82\n" +
"-221\n" +
"-317\n" +
"-330\n" +
"-240\n" +
"-189\n" +
"-12\n" +
"-268\n" +
"-243\n" +
"-177\n" +
"-120\n" +
"-320\n" +
"-127\n" +
"-351\n" +
"-178\n" +
"-219\n" +
"-351\n" +
"-128\n" +
"-28\n" +
"-227\n" +
"-188\n" +
"-195\n" +
"-205\n" +
"-204\n" +
"-283\n" +
"-316\n" +
"-276\n" +
"-319\n" +
"-312\n" +
"-337\n" +
"-318\n" +
"-136\n" +
"-33\n" +
"-307\n" +
"-397\n" +
"-387\n" +
"-303\n" +
"-12\n" +
"-347\n" +
"-112\n" +
"-171\n" +
"-222\n" +
"-358\n" +
"-215\n" +
"-71\n" +
"-99\n" +
"-108\n" +
"-24\n" +
"-291\n" +
"-344\n" +
"-97\n" +
"-99\n" +
"-6\n" +
"-270\n" +
"-327\n" +
"-32\n" +
"-387\n" +
"-402\n" +
"-13\n" +
"-175\n" +
"-243\n" +
"-374\n" +
"-422\n" +
"-382\n" +
"-152\n" +
"-420\n" +
"-266\n" +
"-326\n" +
"-37\n" +
"-215\n" +
"-357\n" +
"-423\n" +
"-16\n" +
"-272\n" +
"-357\n" +
"-87\n" +
"-184\n" +
"-21\n" +
"-351\n" +
"-300\n" +
"-219\n" +
"-390\n" +
"-12\n" +
"-15\n" +
"-78\n" +
"-69\n" +
"-35\n" +
"-308\n" +
"-303\n" +
"-300\n" +
"-265\n" +
"-440\n" +
"-19\n" +
"-117\n" +
"-87\n" +
"-218\n" +
"-163\n" +
"-317\n" +
"-42\n" +
"-55\n" +
"-185\n" +
"-245\n" +
"-196\n" +
"-183\n" +
"-327\n" +
"-467\n" +
"-102\n" +
"-432\n" +
"-162\n" +
"-202\n" +
"-39\n" +
"-179\n" +
"-301\n" +
"-237\n" +
"-299\n" +
"-33\n" +
"-198\n" +
"-127\n" +
"-138\n" +
"-454\n" +
"-46\n" +
"-87\n" +
"-362\n" +
"-448\n" +
"-382\n" +
"-42\n" +
"-358\n" +
"-475\n" +
"-350\n" +
"-50\n" +
"-380\n" +
"-316\n" +
"-380\n" +
"-463\n" +
"-108\n" +
"-405\n" +
"-139\n" +
"-480\n" +
"-30\n" +
"-212\n" +
"-308\n" +
"-239\n" +
"-223\n" +
"-306\n" +
"-81\n" +
"-89\n" +
"-172\n" +
"-304\n" +
"-87\n" +
"-380\n" +
"-394\n" +
"-507\n" +
"-392\n" +
"-98\n" +
"-403\n" +
"-155\n" +
"-13\n" +
"-197\n" +
"-66\n" +
"-244\n" +
"-401\n" +
"-278\n" +
"-391\n" +
"-64\n" +
"-460\n" +
"-368\n" +
"-178\n" +
"-145\n" +
"-440\n" +
"-49\n" +
"-369\n" +
"-418\n" +
"-332\n" +
"-200\n" +
"-294\n" +
"-495\n" +
"-104\n" +
"-5\n" +
"-261\n" +
"-168\n" +
"-392\n" +
"-230\n" +
"-154\n" +
"-472\n" +
"-404\n" +
"-472\n" +
"-307\n" +
"-256\n" +
"-169\n" +
"-330\n" +
"-500\n" +
"-365\n" +
"-146\n" +
"-133\n" +
"-84\n" +
"-336\n" +
"-405\n" +
"-555\n" +
"-74\n" +
"-68\n" +
"-354\n" +
"-552\n" +
"-108\n" +
"-80\n" +
"-406\n" +
"-164\n" +
"-119\n" +
"-487\n" +
"-151\n" +
"-113\n" +
"-244\n" +
"-471\n" +
"-80\n" +
"-312\n" +
"-495\n" +
"-556\n" +
"-76\n" +
"-24\n" +
"-546\n" +
"-493\n" +
"-340\n" +
"-464\n" +
"-328\n" +
"-7\n" +
"-474\n" +
"-246\n" +
"-237\n" +
"-40\n" +
"-199\n" +
"-346\n" +
"-330\n" +
"-139\n" +
"-284\n" +
"-435\n" +
"-83\n" +
"-210\n" +
"-423\n" +
"-361\n" +
"-56\n" +
"-271\n" +
"-140\n" +
"-162\n" +
"-232\n" +
"-391\n" +
"-42\n" +
"-99\n" +
"-590\n" +
"2\n" +
"-271\n" +
"-101\n" +
"-114\n" +
"-117\n" +
"-310\n" +
"-502\n" +
"-287\n" +
"-319\n" +
"-323\n" +
"-362\n" +
"-551\n" +
"-439\n" +
"-533\n" +
"-183\n" +
"-404\n" +
"-401\n" +
"-343\n" +
"-36\n" +
"-89\n" +
"-454\n" +
"-128\n" +
"-611\n" +
"-6\n" +
"-619\n" +
"-110\n" +
"-389\n" +
"-290\n" +
"-270\n" +
"-375\n" +
"-283\n" +
"-472\n" +
"-65\n" +
"-195\n" +
"-129\n" +
"-61\n" +
"-548\n" +
"-151\n" +
"-74\n" +
"-612\n" +
"-156\n" +
"-371\n" +
"-42\n" +
"-447\n" +
"-565\n" +
"-394\n" +
"-550\n" +
"-476\n" +
"-592\n" +
"-262\n" +
"-96\n" +
"-529\n" +
"-395\n" +
"-204\n" +
"-491\n" +
"-167\n" +
"-186\n" +
"-527\n" +
"-508\n" +
"-245\n" +
"-455\n" +
"-552\n" +
"-672\n" +
"-338\n" +
"-269\n" +
"-104\n" +
"-240\n" +
"-77\n" +
"-303\n" +
"-227\n" +
"-453\n" +
"-126\n" +
"-294\n" +
"-572\n" +
"-8\n" +
"-527\n" +
"-361\n" +
"-438\n" +
"-457\n" +
"-513\n" +
"-560\n" +
"-442\n" +
"-649\n" +
"-321\n" +
"-123\n" +
"-52\n" +
"-166\n" +
"-320\n" +
"-301\n" +
"-570\n" +
"-684\n" +
"-325\n" +
"-515\n" +
"-547\n" +
"-52\n" +
"-221\n" +
"-488\n" +
"-182\n" +
"-618\n" +
"-109\n" +
"-497\n" +
"-167\n" +
"-288\n" +
"-358\n" +
"-334\n" +
"-313\n" +
"-288\n" +
"-102\n" +
"-409\n" +
"-143\n" +
"-204\n" +
"-216\n" +
"-681\n" +
"-512\n" +
"-245\n" +
"-301\n" +
"-35\n" +
"-262\n" +
"-239\n" +
"-405\n" +
"-682\n" +
"-715\n" +
"-438\n" +
"-314\n" +
"-179\n" +
"-611\n" +
"-667\n" +
"-622\n" +
"-511\n" +
"-463\n" +
"-370\n" +
"-338\n" +
"-434\n" +
"-580\n" +
"-637\n" +
"-201\n" +
"-213\n" +
"-357\n" +
"-443\n" +
"-382\n" +
"-315\n" +
"-483\n" +
"-399\n" +
"-624\n" +
"-318\n" +
"-226\n" +
"-652\n" +
"-638\n" +
"-743\n" +
"-330\n" +
"-647\n" +
"-146\n" +
"-138\n" +
"-698\n" +
"-511\n" +
"-173\n" +
"-663\n" +
"-333\n" +
"-564\n" +
"-160\n" +
"-239\n" +
"-243\n" +
"-91\n" +
"-65\n" +
"-468\n" +
"-256\n" +
"-197\n" +
"-210\n" +
"-575\n" +
"-420\n" +
"-715\n" +
"-681\n" +
"-454\n" +
"-226\n" +
"-226\n" +
"-339\n" +
"-473\n" +
"-737\n" +
"-62\n" +
"-149\n" +
"-351\n" +
"-770\n" +
"-313\n" +
"-216\n" +
"-491\n" +
"-511\n" +
"-269\n" +
"-628\n" +
"-391\n" +
"-429\n" +
"-110\n" +
"-199\n" +
"-409\n" +
"-516\n" +
"-7\n" +
"-433\n" +
"-405\n" +
"-792\n" +
"-685\n" +
"-615\n" +
"-287\n" +
"-385\n" +
"-627\n" +
"-527\n" +
"-426\n" +
"-626\n" +
"-164\n" +
"-767\n" +
"-794\n" +
"-115\n" +
"-483\n" +
"-323\n" +
"-371\n" +
"-679\n" +
"-772\n" +
"-808\n" +
"-2\n" +
"-16\n" +
"-459\n" +
"-749\n" +
"-569\n" +
"-139\n" +
"-7\n" +
"-555\n" +
"-161\n" +
"-613\n" +
"-230\n" +
"-771\n" +
"-825\n" +
"-241\n" +
"-579\n" +
"-710\n" +
"-73\n" +
"-790\n" +
"-653\n" +
"-655\n" +
"-394\n" +
"-218\n" +
"-711\n" +
"-467\n" +
"-774\n" +
"-694\n" +
"-664\n" +
"-357\n" +
"-29\n" +
"-121\n" +
"-643\n" +
"-742\n" +
"-388\n" +
"-633\n" +
"-440\n" +
"-755\n" +
"-581\n" +
"-661\n" +
"-653\n" +
"-536\n" +
"-596\n" +
"-10\n" +
"-796\n" +
"-230\n" +
"-813\n" +
"-125\n" +
"-540\n" +
"-584\n" +
"-389\n" +
"-144\n" +
"-346\n" +
"-213\n" +
"-444\n" +
"-205\n" +
"-712\n" +
"-651\n" +
"-670\n" +
"-139\n" +
"-60\n" +
"-620\n" +
"-49\n" +
"-284\n" +
"-212\n" +
"-452\n" +
"-520\n" +
"-243\n" +
"-356\n" +
"-348\n" +
"-442\n" +
"-585\n" +
"-202\n" +
"-207\n" +
"-222\n" +
"-47\n" +
"-49\n" +
"-408\n" +
"-571\n" +
"-154\n" +
"-695\n" +
"-802\n" +
"-524\n" +
"-523\n" +
"-617\n" +
"-615\n" +
"-571\n" +
"-92\n" +
"-344\n" +
"-675\n" +
"-613\n" +
"-759\n" +
"-29\n" +
"-833\n" +
"-662\n" +
"-223\n" +
"-46\n" +
"-156\n" +
"-373\n" +
"-412\n" +
"-848\n" +
"-93\n" +
"-695\n" +
"-250\n" +
"-810\n" +
"-477\n" +
"-150\n" +
"-282\n" +
"-789\n" +
"-193\n" +
"-443\n" +
"-193\n" +
"-159\n" +
"-840\n" +
"-755\n" +
"-508\n" +
"-404\n" +
"-307\n" +
"-80\n" +
"-320\n" +
"-14\n" +
"-245\n" +
"-746\n" +
"-610\n" +
"-855\n" +
"-552\n" +
"-323\n" +
"-366\n" +
"-45\n" +
"-16\n" +
"-335\n" +
"-852\n" +
"-46\n" +
"-459\n" +
"-461\n" +
"-537\n" +
"-547\n" +
"-180\n" +
"-842\n" +
"-213\n" +
"-447\n" +
"-712\n" +
"-633\n" +
"-362\n" +
"-953\n" +
"-407\n" +
"-47\n" +
"0\n" +
"-466\n" +
"-107\n" +
"-648\n" +
"-528\n" +
"-413\n" +
"-828\n" +
"-217\n" +
"-484\n" +
"-969\n" +
"-121\n" +
"-858\n" +
"-208\n" +
"-618\n" +
"-384\n" +
"-16\n" +
"-91\n" +
"-662\n" +
"-348\n" +
"-675\n" +
"-63\n" +
"-713\n" +
"-966\n" +
"-678\n" +
"-293\n" +
"-827\n" +
"-445\n" +
"-387\n" +
"-212\n" +
"-763\n" +
"-847\n" +
"-756\n" +
"-299\n" +
"-443\n" +
"-80\n" +
"-286\n" +
"-954\n" +
"-521\n" +
"-394\n" +
"-357\n" +
"-861\n" +
"-530\n" +
"-649\n" +
"-671\n" +
"-437\n" +
"-884\n" +
"-606\n" +
"-73\n" +
"-452\n" +
"-354\n" +
"-729\n" +
"-927\n" +
"-248\n" +
"-2\n" +
"-738\n" +
"-521\n" +
"-440\n" +
"-435\n" +
"-291\n" +
"-104\n" +
"-402\n" +
"-375\n" +
"-875\n" +
"-686\n" +
"-812\n" +
"-539\n" +
"-934\n" +
"-536\n" +
"-924\n" +
"-924\n" +
"-365"));
    }
}
