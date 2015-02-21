package CardGame;
/**
 * I might need this empty
 * @author Bernard Serbinowski
 * @author Seth Zebrack
 */
public class Empty {
	/*Notes
	 * spell speed stat:
	spell constructs:
	turn order:
	time as resource:
	counterspell mechanics
	rts style(i am not a fan of this...wel i sort of am but it seems like it would massively complicate life in terms of how we were doing resources and shit. idk)
	stack mechanics:
	starting points?:
	multiple choices at start of turn:
	yeah I was think something like 50% of strength is added to attack
[4:55:15 PM] Bernard Serbinowski: like i mean we do still want to keep track of that value of attack
[4:55:21 PM] Seth  Zebrack: then you could have a spell for +1 strength or +1 attack
[4:55:34 PM] Bernard Serbinowski: because we don't want to force the user to calculate attack on their own
[4:55:59 PM] Bernard Serbinowski: but if we make it so that attack is just like a result of some other stuff, then i wouldn't really call it a stat
[4:56:27 PM] Seth  Zebrack: yeah, im not sure if it should only be a result of weapon and strength and buffs
[4:56:31 PM] Seth  Zebrack: or if it should be independent
[4:56:42 PM] Seth  Zebrack: up to you
[4:56:52 PM] Bernard Serbinowski: then my decision is we hold off on that
[4:56:57 PM] Seth  Zebrack: ok
[4:57:20 PM] Seth  Zebrack: so with spell speed, should their be priorities such as instants vs soceries
[4:57:29 PM] Seth  Zebrack: and I can respond to your spell casts?
[4:57:46 PM] Bernard Serbinowski: so i'm thinking a more advanced system then that
[4:57:57 PM] Bernard Serbinowski: well sort
[4:57:58 PM] Bernard Serbinowski: of
[4:58:04 PM] Bernard Serbinowski: going back to the time thing
[4:58:17 PM] Bernard Serbinowski: suppose that you start casting a spell that will destroy the world
[4:58:27 PM] Bernard Serbinowski: in addition to havign to pay a shitload of mana because that's hard to do
[4:58:41 PM] Bernard Serbinowski: it also takes you a long time to say all the incantations and shit to cast this spell
[4:58:58 PM] Bernard Serbinowski: suppose it takes you a total of 20 seconds to correctly say all the incantations
[4:59:00 PM] Bernard Serbinowski: in the mean time
[4:59:01 PM] Bernard Serbinowski: i'm like
[4:59:10 PM] Bernard Serbinowski: HOLY SHIT HE'S GONNA DESTROY THE WORLD
[4:59:24 PM] Seth  Zebrack: so I play destroy world card, and you can play any set of spells costing a total of 20 seconds or less in time?
[4:59:25 PM] Bernard Serbinowski: and so i cast a spell that increases my attack for some reason
[4:59:38 PM] Bernard Serbinowski: and it only takes me 5 seconds to say the incantions for this
[4:59:47 PM] Bernard Serbinowski: so then i have 15 more seconds with which to do shit
[4:59:54 PM] Bernard Serbinowski: yeah basically
[5:00:03 PM] Seth  Zebrack: ok cool
[5:00:06 PM] Bernard Serbinowski: well
[5:00:06 PM] Seth  Zebrack: I like that
[5:00:07 PM] Bernard Serbinowski: i mean
[5:00:11 PM] Bernard Serbinowski: if at 15 seconds in
[5:00:17 PM] Bernard Serbinowski: i start casting a 10 second spell
[5:00:26 PM] Bernard Serbinowski: then after destorying the world
[5:00:30 PM] Bernard Serbinowski: you would have 5 more seconds
[5:00:36 PM] Bernard Serbinowski: with which to respond to my last spell
[5:00:52 PM] Seth  Zebrack: what if I cast a 5 seconds spell after destroying the world
[5:00:58 PM] Seth  Zebrack: which triggers first? or can I even?
[5:01:07 PM] Bernard Serbinowski: the one you completed first would trigger first
[5:01:12 PM] Bernard Serbinowski: unless it says something like
[5:01:23 PM] Bernard Serbinowski: this spell triggers after the next 3 casts
[5:01:29 PM] Bernard Serbinowski: or after an additional 5 seconds
[5:01:30 PM] Seth  Zebrack: what if 2 spells end at the same time
[5:01:31 PM] Bernard Serbinowski: or something
[5:01:37 PM] Bernard Serbinowski: hmm
[5:01:50 PM] Bernard Serbinowski: i think it that case it goes back to stats
[5:02:10 PM] Bernard Serbinowski: wait shit
[5:02:13 PM] Bernard Serbinowski: that can by tied
[5:02:24 PM] Bernard Serbinowski: there needs to be an undisputable way with which to resolve that
[5:02:30 PM] Seth  Zebrack: whoevers turn it is
[5:02:32 PM] Seth  Zebrack: resolves first
[5:02:33 PM] Bernard Serbinowski: fair
[5:02:40 PM] Seth  Zebrack: ok, so if its my turn and we are in spell casting phase
[5:02:48 PM] Seth  Zebrack: you don't do anything I have like 5 minutes to decide my card to play
[5:02:53 PM] Seth  Zebrack: I cast a spell for 10 seconds cast time
[5:03:04 PM] Seth  Zebrack: now you can either pass for 10 seconds or begind casting a spell in response
[5:03:10 PM] Bernard Serbinowski: right
[5:03:17 PM] Seth  Zebrack: if you pass its my chance to cast again and you can respond or pass
[5:03:24 PM] Seth  Zebrack: after I cast all my spells and end turn
[5:03:32 PM] Seth  Zebrack: you draw now its your turn to begin casts
[5:03:34 PM] Seth  Zebrack: and gain maana
[5:03:36 PM] Bernard Serbinowski: yup
[5:03:37 PM] Seth  Zebrack: ok
[5:03:40 PM] Seth  Zebrack: I like that
[5:03:47 PM] Bernard Serbinowski: we can add some more strategy
[5:03:56 PM] Bernard Serbinowski: by involving sort of occulting spells
[5:03:59 PM] Bernard Serbinowski: by which i mean
[5:04:06 PM] Bernard Serbinowski: you can see that i'm casting a 20 second spell
[5:04:10 PM] Bernard Serbinowski: but you don't know which one
[5:04:16 PM] Seth  Zebrack: well it leaves a lot of room for counter play also, like 3 second cast stop all currently casting spells
[5:04:26 PM] Seth  Zebrack: yeah I like the occulting
[5:04:26 PM] Bernard Serbinowski: right
[5:04:43 PM] Seth  Zebrack: also this makes more than 2 players fairly easy to integrate eventually
[5:04:48 PM] Bernard Serbinowski: right
[5:05:04 PM] Seth  Zebrack: so do we still like how mana burn works
[5:05:06 PM] Bernard Serbinowski: though i'm still not entirely certain of the nature of these spells
[5:05:12 PM] Bernard Serbinowski: yeah for the most part i do
[5:05:16 PM] Seth  Zebrack: because as is, if I want to counter you, I have to keep open 3 mana
[5:05:19 PM] Bernard Serbinowski: floating resources should be penalized
[5:05:26 PM] Seth  Zebrack: but then I get burned for 3 hp at the end of my turn if you don't play anything
[5:05:28 PM] Bernard Serbinowski: but on the flip side also allows you to do shit
[5:05:34 PM] Seth  Zebrack: yeah, true
[5:05:37 PM] Bernard Serbinowski: ok well then thing is
[5:05:40 PM] Bernard Serbinowski: the way we have this right now
[5:05:49 PM] Seth  Zebrack: and then next turn I can play 4 mana for a total of 7 for a strong card
[5:05:50 PM] Bernard Serbinowski: it's like counterplay has a huge advantage
[5:06:06 PM] Seth  Zebrack: counter play is good though? right?
[5:06:11 PM] Bernard Serbinowski: yeah until the point
[5:06:14 PM] Bernard Serbinowski: where it's so good
[5:06:21 PM] Bernard Serbinowski: that there is no reason to initiate your own play
[5:06:26 PM] Seth  Zebrack: that's why there is attack
[5:06:33 PM] Seth  Zebrack: instead I can equip my armour
[5:06:36 PM] Seth  Zebrack: no room for counter spell
[5:06:39 PM] Seth  Zebrack: and then I get a sword
[5:06:42 PM] Seth  Zebrack: and start stabbing you
[5:06:55 PM] Seth  Zebrack: then I counter your freeze spell
[5:06:57 PM] Bernard Serbinowski: are we counting equip as a non-spell?
[5:07:12 PM] Bernard Serbinowski: i'm actually curious
[5:07:13 PM] Seth  Zebrack: i think there should be some non-spells such a swords
[5:07:27 PM] Seth  Zebrack: but there could also be a spell to summon a sword with magic
[5:07:28 PM] Bernard Serbinowski: aight
[5:07:33 PM] Seth  Zebrack: which is counterable
[5:07:55 PM] Seth  Zebrack: and costs less from int instead of strength because its magic
[5:07:58 PM] Bernard Serbinowski: ok so then my question is equip sort of always just an uncounterable sorcery speed type deal?
[5:08:09 PM] Bernard Serbinowski: so like
[5:08:23 PM] Bernard Serbinowski: you can equip only on your turn but it can't be countered
[5:08:33 PM] Seth  Zebrack: also what if at the start of each turn you choose to do 2 of the following, draw 1 card, gain +1 strength, gain +1 int, turn a card into resources?
[5:08:36 PM] Bernard Serbinowski: while spells can be cast at any time that you can respond?
[5:09:04 PM] Bernard Serbinowski: that sound reasonable (obviosuly values woudl have to be tweaked)
[5:09:21 PM] Bernard Serbinowski: (since i still don't even know how much hp we have or strength or anything)
[5:09:30 PM] Bernard Serbinowski: (or even deck size)
[5:09:44 PM] Seth  Zebrack: yeah, but i think i like that at the start of your turn you have a lot of good choices,
[5:09:52 PM] Bernard Serbinowski: hmm
[5:10:00 PM] Bernard Serbinowski: i do we could limit it somewhat
[5:10:37 PM] Bernard Serbinowski: (draw 1 card || gain resouces) && (gain 1 strength || gain 1 int)
[5:10:48 PM] Seth  Zebrack: yeah, i like that
[5:11:18 PM] Seth  Zebrack: but if its draw or gain materials, then there should also be a mandatory draw
[5:11:24 PM] Seth  Zebrack: or we need sick draw mechanics
[5:11:34 PM] Bernard Serbinowski: should we let people alot say a total of like 10 points into stats before the game starts?
[5:11:57 PM] Seth  Zebrack: or maybe instead of turning your card into materials, you reveal the card to gain 1/2/3/4... materials of its color
[5:12:14 PM] Seth  Zebrack: that way you don't lose cards to gain resources but lose out on the draw
[5:12:41 PM] Bernard Serbinowski: so as to that
[5:12:51 PM] Bernard Serbinowski: i think it basically ends up being a really similar idea
[5:13:00 PM] Bernard Serbinowski: with just some minor tweaks involved
[5:13:10 PM] Bernard Serbinowski: so i think we can delay on that for a bit
[5:13:16 PM] Seth  Zebrack: so that 10 before game points, is interesting, but if we did that, then its more of a class construction, like you build up yourself before hand, and you are a character, maybe a mage, warrior, or some combo
[5:13:17 PM] Bernard Serbinowski: if we were to do that though
[5:13:33 PM] Bernard Serbinowski: would you allow people to reveal the same card twice?
[5:13:44 PM] Bernard Serbinowski: like turn a) reveal card a for x mana
[5:13:54 PM] Bernard Serbinowski: turn b) reveal card a for x mana again
[5:14:02 PM] Seth  Zebrack: it would be x+1
[5:14:11 PM] Bernard Serbinowski: ok but can you reveal the same card again?
[5:14:17 PM] Seth  Zebrack: idk
[5:15:12 PM | Edited 5:15:35 PM] Seth  Zebrack: but with the pre-allotted points, would you want to have a character creation, where you create your character, and you have 10 points to place into your stat pool, with a class and race system?
[5:15:27 PM] Bernard Serbinowski: no i was thinking that as like
[5:15:33 PM] Bernard Serbinowski: a pre turn 1 phase
[5:15:41 PM] Seth  Zebrack: ahh ok
[5:15:44 PM] Bernard Serbinowski: you take turns alloting points
[5:16:02 PM] Seth  Zebrack: so if i see you placing a lot of points into int i might put a few into int and the rest into spell speed?
[5:16:10 PM] Bernard Serbinowski: yeah
[5:16:21 PM] Bernard Serbinowski: though i'm not really sure if this is a good idea
[5:16:30 PM] Bernard Serbinowski: just something i was throwing out there becuase why not
[5:17:00 PM] Seth  Zebrack: ok, and maybe each player reveals a card from their starting hand allowing and both players get points = to the revealed cards cost, thus you have some info about the others deck
[5:17:26 PM] Seth  Zebrack: and the starting points vary in number
[5:17:31 PM] Seth  Zebrack: for some difference in game play
[5:17:37 PM] Seth  Zebrack: idk, nvm this isn't important now
[5:18:04 PM] Seth  Zebrack: so should i have the choice to be able to place my points into attack or strength, thus they are 2 different stats
	 */
	
}
